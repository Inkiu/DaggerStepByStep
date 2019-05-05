package com.example.daggerstepbystep.di.app

import android.app.Activity
import com.example.daggerstepbystep.di.app.login.LoginModule
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        MainComponent::class
    ]
)
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainComponent.Builder): AndroidInjector.Factory<out Activity>
}