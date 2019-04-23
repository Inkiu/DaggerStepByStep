package com.example.daggerstepbystep.ui.detail

import com.example.daggerstepbystep.data.UserRepository
import com.example.daggerstepbystep.data.login.LoginManager
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: DetailContract.View,
    private val loginManager: LoginManager,
    private val userRepository: UserRepository
) : DetailContract.Presenter {

    override fun onCreate() {
        val loginUser = loginManager.getLoginUser()
        val detail = userRepository.getUserDetail(loginUser)
        view.onBindDetail(detail)
    }
}