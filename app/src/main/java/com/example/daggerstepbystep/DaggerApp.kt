package com.example.daggerstepbystep

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.data.login.UserProvider
import com.example.daggerstepbystep.di.app.AppComponent
import com.example.daggerstepbystep.di.app.AppModule
import com.example.daggerstepbystep.di.app.DaggerAppComponent
import com.example.daggerstepbystep.di.app.user.UserComponent
import com.example.daggerstepbystep.di.app.user.UserModule
import javax.inject.Inject

class DaggerApp : Application() {
    companion object {
        fun get(context: Context): DaggerApp = context.applicationContext as DaggerApp
    }

    @Inject
    lateinit var userProvider: UserProvider

    lateinit var appComponent: AppComponent
    lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()

        buildAppComponent()
    }

    private fun buildAppComponent() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }

    fun buildUserComponent() {
        if (!::userComponent.isInitialized) {
            userComponent = appComponent.plus(UserModule(userProvider))
        }
    }
}