package com.blabs.analytics.combined.analytics_tools.web_engage

import android.app.Application
import android.content.Context
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import com.blabs.analytics.combined.utils.enums.AnalyticsTool
import com.blabs.analytics.combined.utils.enums.ApiKeys
import com.blabs.analytics.combined.utils.getValuesFromMetaData
import com.google.firebase.BuildConfig
import com.webengage.sdk.android.Analytics
import com.webengage.sdk.android.LocationTrackingStrategy
import com.webengage.sdk.android.WebEngage
import com.webengage.sdk.android.WebEngageActivityLifeCycleCallbacks
import com.webengage.sdk.android.WebEngageConfig


class WebEngageAnalyticsTracker : AnalyticsTracker {

    private var weAnalytics: Analytics? = null
    override fun initialize(context: Context) {
        val webEngage = WebEngageConfig.Builder()
            .setWebEngageKey(context.getValuesFromMetaData(ApiKeys.WEB_ENGAGE_KEY))
            .setDebugMode(BuildConfig.DEBUG)
            .setLocationTrackingStrategy(LocationTrackingStrategy.DISABLED).build()
        (context as Application).registerActivityLifecycleCallbacks(
            WebEngageActivityLifeCycleCallbacks(context, webEngage)
        )
        weAnalytics = WebEngage.get().analytics()

    }

    override fun trackEvent(eventName: String, parameters: Map<String, Any>) {
        val map: MutableMap<String, Any> = HashMap()
        parameters.forEach { (key, value) ->
            map[key] = value
        }
        weAnalytics?.track(eventName, map)
    }

    override fun trackScreen(eventName: String, parameters: Map<String, Any>) {
        val map: MutableMap<String, Any> = HashMap()
        parameters.forEach { (key, value) ->
            map[key] = value
        }
        weAnalytics?.screenNavigated(eventName, map)
    }

    override fun getAnalyticsTool(): AnalyticsTool {
        return AnalyticsTool.WEB_ENGAGE
    }
}