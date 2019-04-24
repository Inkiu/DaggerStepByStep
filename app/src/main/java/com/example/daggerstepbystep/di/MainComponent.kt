package com.example.daggerstepbystep.di

import com.example.daggerstepbystep.di.login.LoginComponent
import com.example.daggerstepbystep.di.login.LoginModule
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.main.MainUserComponent
import com.example.daggerstepbystep.di.main.MainUserModule
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    /* Sub Components */
    fun plus(loginModule: LoginModule): LoginComponent

    fun plus(mainUserModule: MainUserModule): MainUserComponent

}