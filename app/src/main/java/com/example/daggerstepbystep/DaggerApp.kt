package com.example.daggerstepbystep

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.di.ApplicationComponent
import com.example.daggerstepbystep.di.ApplicationModule
import com.example.daggerstepbystep.di.DaggerApplicationComponent
import javax.inject.Inject

class DaggerApp : Application() {
    companion object {
        fun get(context: Context): DaggerApp = context.applicationContext as DaggerApp
    }

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}