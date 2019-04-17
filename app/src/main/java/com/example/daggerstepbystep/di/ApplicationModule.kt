package com.example.daggerstepbystep.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.daggerstepbystep.data.SharedPrefsHelper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(
    private val application: Application
) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = "demo-dagger.db"

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int = 1

    @Provides
    fun provideSharedPrefs(): SharedPreferences = application.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE)
}