package com.blabs.analytics.combined.interfaces

import com.blabs.analytics.combined.enums.AnalyticsTool

interface AnalyticsTracker {

    fun trackEvent(eventName: String, parameters: Map<String, Any>)
    fun trackScreen(screenName: String, parameters: Map<String, Any>)
    fun getAnalyticsTool(): AnalyticsTool
    // Add more methods as needed for your analytics needs
}