package com.blabs.analytics.combined.manager

import com.blabs.analytics.combined.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsInitializer
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.combined.interfaces.AnalyticsTracker
import javax.inject.Inject

class AnalyticsManagerImpl(
) : AnalyticsManager {

    private val analyticsTrackers: Set<AnalyticsTracker> = setOf()
    private val analyticsInitializers: Map<AnalyticsTool, AnalyticsInitializer> = mapOf()

    override fun provideTrackersAndInitializers(): Pair<Set<AnalyticsTracker>, Map<AnalyticsTool, AnalyticsInitializer>> {
        return Pair(analyticsTrackers, analyticsInitializers)
    }


    override fun initializeAnalyticsTools(vararg tools: AnalyticsTool) {
        analyticsInitializers.forEach { (tool, initializer) ->
            if (tools.isEmpty() || tools.contains(tool)) {
                initializer.initialize()
            }
        }
    }

    override fun trackEvent(
        eventName: String, parameters: Map<String, Any>, vararg tools: AnalyticsTool
    ) {
        analyticsTrackers.forEach { tracker ->
            if (tools.isEmpty() || tools.contains(tracker.getAnalyticsTool())) {
                tracker.trackEvent(eventName, parameters)
            }
        }
    }

    override fun trackScreen(
        screenName: String, parameters: Map<String, Any>, vararg tools: AnalyticsTool
    ) {
        analyticsTrackers.forEach { tracker ->
            if (tools.isEmpty() || tools.contains(tracker.getAnalyticsTool())) {
                tracker.trackScreen(screenName, parameters)
            }
        }
    }
}