package com.example.daggerstepbystep

import android.app.Application
import android.content.Context
import com.example.daggerstepbystep.di.app.AppComponent
import com.example.daggerstepbystep.di.app.AppModule
import com.example.daggerstepbystep.di.app.DaggerAppComponent
import com.example.daggerstepbystep.di.app.user.UserComponent
import javax.inject.Inject

/*
* TODO 로그인 레이어 위에 유저 레이어 올리기
* */

class DaggerApp : Application() {
    companion object {
        fun get(context: Context): DaggerApp = context.applicationContext as DaggerApp
    }

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
}