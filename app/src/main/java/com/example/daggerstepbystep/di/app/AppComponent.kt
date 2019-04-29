package com.example.daggerstepbystep.di.app

import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.di.app.user.UserComponent
import com.example.daggerstepbystep.di.app.user.UserModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class
])
interface AppComponent {
    fun inject(application: DaggerApp)

//    fun plus(loginModule: LoginModule): LoginComponent
    fun plus(userModule: UserModule): UserComponent
}