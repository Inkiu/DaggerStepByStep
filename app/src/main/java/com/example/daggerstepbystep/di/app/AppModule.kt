package com.example.daggerstepbystep.di.app

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.data.login.LoginManager
import com.example.daggerstepbystep.data.login.UserProvider
import com.example.daggerstepbystep.di.ApplicationContext
import com.example.daggerstepbystep.di.app.login.LoginComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [LoginComponent::class]
)
class AppModule(
    private val application: Application
) {
    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideUserProvider(): UserProvider = UserProvider(application)
}