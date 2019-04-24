package com.example.daggerstepbystep.di.login

import com.example.daggerstepbystep.ui.login.LoginContract
import com.example.daggerstepbystep.ui.login.LoginFragment
import com.example.daggerstepbystep.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule(
    private val fragment: LoginFragment
) {
    @Provides
    fun provideLoginView(): LoginContract.View = fragment

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter = presenter
}