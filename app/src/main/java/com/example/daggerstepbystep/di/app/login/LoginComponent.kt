package com.example.daggerstepbystep.di.app.login

import com.example.daggerstepbystep.di.PerLogin
import com.example.daggerstepbystep.ui.login.LoginActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerLogin
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent : AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginActivity>() {
        abstract fun loginModule(module: LoginModule)

        override fun seedInstance(instance: LoginActivity) {
            loginModule(LoginModule(instance))
        }
    }

}