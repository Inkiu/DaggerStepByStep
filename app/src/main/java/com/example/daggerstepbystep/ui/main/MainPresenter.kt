package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.data.user.UserRepository
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val userRepository: UserRepository
) : MainContract.Presenter {

    override fun onCreate() {
        view.onBindUser(userRepository.getUser())
    }
}