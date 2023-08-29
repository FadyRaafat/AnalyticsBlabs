package com.blabs.analytics.combined.analytics_tools.amplitude

import com.blabs.analytics.combined.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import timber.log.Timber
import javax.inject.Inject

class AmplitudeTracker : AnalyticsTracker {
    override fun trackEvent(eventName: String, parameters: Map<String, Any>) {
        //  logic for Firebase Analytics
        Timber.d("timber AmplitudeTracker.trackEvent() eventName: $eventName parameters: $parameters")
    }

    override fun trackScreen(screenName: String, parameters: Map<String, Any>) {
        //  tracking logic for Firebase Analytics
        Timber.d("timber AmplitudeTracker.trackScreen() screenName: $screenName parameters: $parameters")
    }

    override fun getAnalyticsTool(): AnalyticsTool {
        return AnalyticsTool.GOOGLE_ANALYTICS
    }
}