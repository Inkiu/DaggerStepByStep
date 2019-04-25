package com.example.daggerstepbystep.data.user

import com.example.daggerstepbystep.di.PerLogin
import javax.inject.Inject

@PerLogin
class UserRepository @Inject constructor(
    private val userDatabase: UserDatabase
) {

}