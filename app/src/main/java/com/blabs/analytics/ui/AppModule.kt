package com.blabs.analytics.ui

import android.content.SharedPreferences
import com.blabs.analytics.combined.interfaces.AnalyticsManager
import com.blabs.analytics.combined.manager.AnalyticsManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAnalyticsManager(): AnalyticsManager {
        return AnalyticsManagerImpl()
    }

}
