package com.example.daggerstepbystep.di

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.data.user.UserDatabase
import com.example.daggerstepbystep.data.SharedPrefsHelper
import com.example.daggerstepbystep.data.login.LoginManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: DaggerApp)

    @ApplicationContext
    fun getContext(): Context

    fun getApplication(): Application

    fun getDataManager(): DataManager

    fun getPreferenceHelper(): SharedPrefsHelper

    fun getDbHelper(): UserDatabase

    fun getLoginManager(): LoginManager
}