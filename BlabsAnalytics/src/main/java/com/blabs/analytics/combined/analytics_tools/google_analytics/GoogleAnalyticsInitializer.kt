package com.blabs.analytics.combined.analytics_tools.google_analytics

import com.blabs.analytics.combined.interfaces.AnalyticsInitializer
import timber.log.Timber
import javax.inject.Inject

class GoogleAnalyticsInitializer  : AnalyticsInitializer {
    override fun initialize() {
        // Initialize Google Analytics
        Timber.d("timber GoogleAnalyticsInitializer.initialize()")
    }
}
