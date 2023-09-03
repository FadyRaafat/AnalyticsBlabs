package com.blabs.analytics.ui

import android.content.Context
import com.blabs.analytics.combined.analytics_tools.amplitude.AmplitudeAnalyticsTracker
import com.blabs.analytics.combined.analytics_tools.firebase_analytics.FirebaseAnalyticsTracker
import com.blabs.analytics.combined.analytics_tools.web_engage.WebEngageAnalyticsTracker
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.combined.manager.AnalyticsManagerImpl
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAnalyticsManager(
        @ApplicationContext appContext: Context
    ): AnalyticsManager {
        return AnalyticsManagerImpl(
            setOf(
                FirebaseAnalyticsTracker(
                    Firebase.analytics
                ), AmplitudeAnalyticsTracker(), WebEngageAnalyticsTracker()
            ), appContext
        )
    }

}
