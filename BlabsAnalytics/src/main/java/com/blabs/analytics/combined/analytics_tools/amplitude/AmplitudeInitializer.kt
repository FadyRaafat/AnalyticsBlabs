package com.blabs.analytics.combined.analytics_tools.amplitude

import com.blabs.analytics.combined.interfaces.AnalyticsInitializer
import timber.log.Timber
import javax.inject.Inject

class AmplitudeInitializer  : AnalyticsInitializer {
    override fun initialize() {
        // Initialize Amplitude
        Timber.d("timber AmplitudeInitializer.initialize()")
    }
}
