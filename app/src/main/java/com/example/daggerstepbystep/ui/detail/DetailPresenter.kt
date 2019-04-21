package com.example.daggerstepbystep.ui.detail

import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.data.UserRepository
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: DetailContract.View,
    private val dataManager: DataManager,
    private val userRepository: UserRepository
) : DetailContract.Presenter {

    override fun onCreate() {
        val loginUser = dataManager.getLoginUser()
        val detail = userRepository.getUserDetail(loginUser)
        view.onBindDetail(detail)
    }
}