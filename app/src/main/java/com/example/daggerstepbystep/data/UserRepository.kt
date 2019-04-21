package com.example.daggerstepbystep.data

import android.content.Context
import com.example.daggerstepbystep.di.ApplicationContext
import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.model.UserDetail
import javax.inject.Inject

@PerActivity
class UserRepository @Inject constructor(
    @ApplicationContext private val context: Context
)  {
    fun getUserDetail(user: User): UserDetail {
        return UserDetail(user.id, "Test user detail ${user.id}")
    }
}