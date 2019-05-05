package com.example.daggerstepbystep.di.app

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val application: Application
) {
    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application
}