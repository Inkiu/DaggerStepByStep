package com.example.daggerstepbystep.data.api

import com.example.daggerstepbystep.data.login.TokenManager
import com.example.daggerstepbystep.di.PerLogin
import com.example.daggerstepbystep.model.User
import javax.inject.Inject

@PerLogin
class RestApi @Inject constructor(
    private val tokenManager: TokenManager
) {
    fun getUser(): User {
        return User(
            id = 1,
            name = "Ali",
            address = "1367, Gurgaon, Haryana, India"
        )
    }
}