package com.example.daggerstepbystep.ui.user

import com.example.daggerstepbystep.data.user.UserRepository
import javax.inject.Inject

class InfoPresenter @Inject constructor(
    private val view: InfoContract.View,
    private val userRepository: UserRepository
) : InfoContract.Presenter {

    override fun onCreate() {
        view.onBindInfo(userRepository.getUser())
    }
}