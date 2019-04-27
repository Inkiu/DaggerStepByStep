package com.example.daggerstepbystep.di.app

import android.app.Application
import com.example.daggerstepbystep.di.app.login.LoginComponent
import com.example.daggerstepbystep.di.app.login.LoginModule
import com.example.daggerstepbystep.di.app.user.UserComponent
import com.example.daggerstepbystep.di.app.user.UserModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(application: Application)

    fun plus(loginModule: LoginModule): LoginComponent
    fun plus(userModule: UserModule): UserComponent
}