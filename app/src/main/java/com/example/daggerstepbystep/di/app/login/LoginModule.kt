package com.example.daggerstepbystep.di.app.login

import android.content.Context
import com.example.daggerstepbystep.data.login.LoginManager
import com.example.daggerstepbystep.data.login.UserProvider
import com.example.daggerstepbystep.di.ActivityContext
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.login.LoginContract
import com.example.daggerstepbystep.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class LoginModule(
    private val activity: LoginActivity
) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): LoginActivity = activity

    @Provides
    fun provideLoginView(): LoginContract.View = activity

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter = presenter

    @Provides
    fun provideLoginManager(userProvider: UserProvider): LoginManager = LoginManager(activity, userProvider)
}