package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.data.login.LogoutManager
import com.example.daggerstepbystep.data.user.UserRepository
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val logoutManager: LogoutManager
) : MainContract.Presenter {

    override fun onLogout() {
        logoutManager.logout()
        view.onRestartApp()
    }

}