package com.blabs.analytics.combined.analytics_tools.firebase_analytics

import android.content.Context
import android.os.Bundle
import com.blabs.analytics.combined.utils.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import com.blabs.analytics.combined.utils.set
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalyticsTracker(private val firebaseApp: FirebaseAnalytics) : AnalyticsTracker {

    private var firebaseAnalytics: FirebaseAnalytics? = null
    override fun initialize(context: Context) {
        firebaseAnalytics = firebaseApp
    }

    override fun trackEvent(eventName: String, parameters: Map<String, Any>?) {
        val bundle = Bundle()
        parameters?.forEach { (key, value) ->
            bundle.set(key, value)
        }
        firebaseAnalytics?.logEvent(eventName, bundle)

    }

    override fun trackScreen(eventName: String, parameters: Map<String, Any>?) {
        val bundle = Bundle()
        parameters?.forEach { (key, value) ->
            bundle.set(key, value)
        }
        firebaseAnalytics?.logEvent(eventName, bundle)
    }

    override fun getAnalyticsTool(): AnalyticsTool {
        return AnalyticsTool.FIREBASE_ANALYTICS
    }
}