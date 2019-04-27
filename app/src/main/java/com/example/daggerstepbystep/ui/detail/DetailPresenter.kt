package com.example.daggerstepbystep.ui.detail

import com.example.daggerstepbystep.data.user.UserDetailRepository
import com.example.daggerstepbystep.data.user.UserRepository
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: DetailContract.View,
    private val userRepository: UserRepository,
    private val userDetailRepository: UserDetailRepository
) : DetailContract.Presenter {

    override fun onCreate() {
        view.onBindInfo(userDetailRepository.getUserDetail())
    }
}