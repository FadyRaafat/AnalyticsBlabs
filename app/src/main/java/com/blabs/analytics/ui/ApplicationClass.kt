package com.blabs.analytics.ui

import android.app.Application
import com.blabs.analytics.combined.analytics_tools.firebase_analytics.FirebaseAnalyticsInitializer
import com.blabs.analytics.combined.analytics_tools.firebase_analytics.FirebaseAnalyticsTracker
import com.blabs.analytics.combined.analytics_tools.google_analytics.GoogleAnalyticsInitializer
import com.blabs.analytics.combined.analytics_tools.google_analytics.GoogleAnalyticsTracker
import com.blabs.analytics.combined.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.combined.manager.AnalyticsManagerImpl
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class ApplicationClass : Application() {


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        // Initialize analytics tools
    }
}