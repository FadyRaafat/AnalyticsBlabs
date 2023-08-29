package com.blabs.analytics.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blabs.analytics.combined.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel: AnalyticsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.trackEvent("Login", mapOf("user_id" to "123"))

        //viewModel.trackEvent("Login", mapOf("user_id" to "123"))

//        analyticsManager.initializeAnalyticsTools(
//            AnalyticsTool.GOOGLE_ANALYTICS, AnalyticsTool.FIREBASE_ANALYTICS
//        )
//
//        // Track events and screens
//        analyticsManager.trackEvent(
//            "Login", mapOf("user_id" to "123"), AnalyticsTool.GOOGLE_ANALYTICS
//        )
//        analyticsManager.trackScreen("Home", emptyMap(), AnalyticsTool.FIREBASE_ANALYTICS)

//
    }
}