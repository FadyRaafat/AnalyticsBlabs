package com.blabs.analytics.combined.analytics_tools.amplitude

import android.app.Application
import android.content.Context
import com.amplitude.api.Amplitude
import com.amplitude.api.AmplitudeClient
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import com.blabs.analytics.combined.utils.enums.AnalyticsTool
import com.blabs.analytics.combined.utils.enums.ApiKeys
import com.blabs.analytics.combined.utils.getValuesFromMetaData
import org.json.JSONObject


class AmplitudeAnalyticsTracker : AnalyticsTracker {

    private var amplitudeClient: AmplitudeClient? = null
    override fun initialize(context: Context) {
        amplitudeClient = Amplitude.getInstance()
            .initialize(context, context.getValuesFromMetaData(ApiKeys.AMPLITUDE_API_KEY))
            .enableForegroundTracking(context as Application)
    }

    override fun trackEvent(eventName: String, parameters: Map<String, Any>) {
        val eventProperties = JSONObject()
        parameters.forEach { (key, value) ->
            eventProperties.put(key, value)
        }
        amplitudeClient?.logEvent(eventName, eventProperties)

    }

    override fun trackScreen(eventName: String, parameters: Map<String, Any>) {
        val eventProperties = JSONObject()
        parameters.forEach { (key, value) ->
            eventProperties.put(key, value)
        }
        amplitudeClient?.logEvent(eventName, eventProperties)
    }

    override fun getAnalyticsTool(): AnalyticsTool {
        return AnalyticsTool.AMPLITUDE
    }
}