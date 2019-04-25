package com.example.daggerstepbystep.data.user

import com.example.daggerstepbystep.data.api.RestApi
import com.example.daggerstepbystep.di.PerLogin
import com.example.daggerstepbystep.model.User
import javax.inject.Inject

@PerLogin
class UserRepository @Inject constructor(
    private val userDatabase: UserDatabase,
    private val restApi: RestApi
) {
    fun getUser(): User {
        val user = restApi.getUser()
        userDatabase.insertUser(user)
        return userDatabase.getUser(user.id)
    }
}