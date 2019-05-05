package com.example.daggerstepbystep.di.login

import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.login.LoginContract
import com.example.daggerstepbystep.ui.login.LoginPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {
    @Binds
    abstract fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter

    @Binds
    abstract fun provideLoginView(loginActivity: LoginActivity): LoginContract.View
}