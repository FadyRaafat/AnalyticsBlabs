package com.blabs.analytics.combined.interfaces

import com.blabs.analytics.combined.enums.AnalyticsTool

interface AnalyticsManager {

    fun provideTrackersAndInitializers(): Pair<Set<AnalyticsTracker>, Map<AnalyticsTool, AnalyticsInitializer>>
    fun initializeAnalyticsTools(vararg tools: AnalyticsTool)
    fun trackEvent(eventName: String, parameters: Map<String, Any>, vararg tools: AnalyticsTool)
    fun trackScreen(screenName: String, parameters: Map<String, Any>, vararg tools: AnalyticsTool)
}