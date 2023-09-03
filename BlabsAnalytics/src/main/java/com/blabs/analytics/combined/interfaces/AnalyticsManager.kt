package com.blabs.analytics.combined.interfaces

import com.blabs.analytics.combined.utils.enums.AnalyticsTool

/**
 * AnalyticsManager is an interface which contains the list of all the functions that an analytics manager should implement.
 */
interface AnalyticsManager {

    fun trackEvent(eventName: String, parameters: Map<String, Any>?, vararg tools: AnalyticsTool)
    fun trackScreen(eventName: String, parameters: Map<String, Any>?, vararg tools: AnalyticsTool)
}