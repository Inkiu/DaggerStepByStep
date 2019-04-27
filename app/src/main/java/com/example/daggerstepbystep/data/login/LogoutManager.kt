package com.example.daggerstepbystep.data.login

import javax.inject.Inject

class LogoutManager @Inject constructor(
    private val userProvider: UserProvider
) {
    fun logout() {
        userProvider.clearLoginToken()
    }
}