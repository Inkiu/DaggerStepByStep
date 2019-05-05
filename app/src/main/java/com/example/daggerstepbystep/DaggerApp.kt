package com.example.daggerstepbystep

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import com.example.daggerstepbystep.di.app.AppComponent
import com.example.daggerstepbystep.di.app.AppModule
import com.example.daggerstepbystep.di.app.DaggerAppComponent
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class DaggerApp : Application(), HasActivityInjector {
    companion object {
        fun get(context: Context): DaggerApp = context.applicationContext as DaggerApp
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        buildAppComponent()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    private fun buildAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }

    fun restartApp(context: Context) {
        startActivity(
            Intent(context, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
        )
    }
}