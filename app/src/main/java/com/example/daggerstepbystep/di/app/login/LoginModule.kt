package com.example.daggerstepbystep.di.app.login

import android.content.Context
import com.example.daggerstepbystep.data.login.LoginManager
import com.example.daggerstepbystep.data.login.UserProvider
import com.example.daggerstepbystep.di.ActivityContext
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.login.LoginContract
import com.example.daggerstepbystep.ui.login.LoginPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LoginModule {
    @Binds
    abstract fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter

    @Binds
    abstract fun provideLoginView(loginActivity: LoginActivity): LoginContract.View
}