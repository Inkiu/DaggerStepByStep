package com.example.daggerstepbystep.data.user

import com.example.daggerstepbystep.data.login.UserProvider
import com.example.daggerstepbystep.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userProvider: UserProvider
) {
    fun getUser(): User {
        val token = userProvider.getLoginToken()
        return User(
            1,
            "Ali",
            "${token.accessToken}/${token.refreshToken}"
        )
    }
}