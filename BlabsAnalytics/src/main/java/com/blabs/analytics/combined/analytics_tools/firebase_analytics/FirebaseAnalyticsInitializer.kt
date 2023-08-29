package com.blabs.analytics.combined.analytics_tools.firebase_analytics

import com.blabs.analytics.combined.interfaces.AnalyticsInitializer
import timber.log.Timber
import javax.inject.Inject

class FirebaseAnalyticsInitializer  : AnalyticsInitializer {
    override fun initialize() {
        // Initialize Firebase Analytics
        Timber.d("timber FirebaseAnalyticsInitializer.initialize()")
    }
}