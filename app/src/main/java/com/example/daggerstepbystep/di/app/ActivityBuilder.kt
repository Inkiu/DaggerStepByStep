package com.example.daggerstepbystep.di.app

import android.app.Activity
import com.example.daggerstepbystep.di.app.login.LoginComponent
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        LoginComponent::class,
        MainComponent::class
    ]
)
abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
    abstract fun bindLoginActivity(builder: LoginComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>
}