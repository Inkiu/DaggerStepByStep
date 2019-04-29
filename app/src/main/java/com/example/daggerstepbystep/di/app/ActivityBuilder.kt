package com.example.daggerstepbystep.di.app

import android.app.Activity
import com.example.daggerstepbystep.di.app.login.LoginComponent
import com.example.daggerstepbystep.ui.login.LoginActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(LoginActivity::class)
    abstract fun bindLoginActivity(builder: LoginComponent.Builder): AndroidInjector.Factory<out Activity>
}