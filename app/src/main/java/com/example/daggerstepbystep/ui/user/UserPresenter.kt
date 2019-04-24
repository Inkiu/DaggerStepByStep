package com.example.daggerstepbystep.ui.user

import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.data.login.LoginManager
import javax.inject.Inject

class UserPresenter @Inject constructor(
    private val view: UserContract.View,
    private val loginManager: LoginManager,
    private val dataManager: DataManager
): UserContract.Presenter {

    override fun onCreate() {
        view.onBindUser(loginManager.getLoginUser())
        view.onBindAccessToken(dataManager.getAccessToken())
    }

}