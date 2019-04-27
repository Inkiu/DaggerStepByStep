package com.example.daggerstepbystep.data.user

import com.example.daggerstepbystep.model.UserDetail
import javax.inject.Inject

class UserDetailRepository @Inject constructor(
    private val userRepository: UserRepository
) {
    fun getUserDetail(): UserDetail {
        return UserDetail(userRepository.getUser().toString())
    }
}