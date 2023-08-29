package com.blabs.analytics.ui

import androidx.lifecycle.ViewModel
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val analyticsManager: AnalyticsManager
) : ViewModel() {
    fun trackEvent(eventName: String, parameters: Map<String, Any>) {
        analyticsManager.trackEvent(eventName, parameters)
    }

    fun trackScreen(screenName: String, parameters: Map<String, Any>) {
        analyticsManager.trackScreen(screenName, parameters)
    }
}