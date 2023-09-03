package com.blabs.analytics.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blabs.analytics.combined.utils.enums.AnalyticsTool
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var analyticsManager: AnalyticsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.test.setOnClickListener {
            // Testing all the analytics tools
            analyticsManager.trackEvent("testing_all", mapOf("key_1" to "value_1"))

            // Testing Amplitude SDK
            analyticsManager.trackEvent(
                "testing_amplitude", mapOf("key_2" to "value_2"), AnalyticsTool.AMPLITUDE
            )

            // Testing Firebase Analytics
            analyticsManager.trackEvent(
                "testing_firebase", mapOf("key_3" to "value_3"), AnalyticsTool.FIREBASE_ANALYTICS
            )

            // Testing Web Engage
            analyticsManager.trackEvent(
                "testing_web_engage", mapOf("key_4" to "value_4"), AnalyticsTool.WEB_ENGAGE
            )

            // Testing all the analytics tools manually
            analyticsManager.trackEvent(
                "testing_all_manually",
                mapOf("key_4" to "value_4"),
                AnalyticsTool.AMPLITUDE,
                AnalyticsTool.FIREBASE_ANALYTICS,
                AnalyticsTool.WEB_ENGAGE
            )
        }

    }
}