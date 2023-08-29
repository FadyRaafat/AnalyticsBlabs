package com.blabs.analytics.combined.analytics_tools.google_analytics

import com.blabs.analytics.combined.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import timber.log.Timber
import javax.inject.Inject

class GoogleAnalyticsTracker : AnalyticsTracker {
    override fun trackEvent(eventName: String, parameters: Map<String, Any>) {
        //  logic for Firebase Analytics
        Timber.d("timber GoogleAnalyticsTracker.trackEvent() eventName: $eventName parameters: $parameters")
    }

    override fun trackScreen(screenName: String, parameters: Map<String, Any>) {
        //  tracking logic for Firebase Analytics
        Timber.d("timber GoogleAnalyticsTracker.trackScreen() screenName: $screenName parameters: $parameters")
    }

    override fun getAnalyticsTool(): AnalyticsTool {
        return AnalyticsTool.GOOGLE_ANALYTICS
    }
}