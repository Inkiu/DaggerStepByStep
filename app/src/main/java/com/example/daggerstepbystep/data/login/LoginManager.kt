package com.example.daggerstepbystep.data.login

import android.content.res.Resources
import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.data.SharedPrefsHelper
import com.example.daggerstepbystep.model.User
import javax.inject.Inject
import javax.inject.Singleton

const val LOGIN_KEY = "login_user"

@Singleton
class LoginManager @Inject constructor(
    private val sharedPrefsHelper: SharedPrefsHelper,
    private val dataManager: DataManager
) {
    fun login(user: User) {
        sharedPrefsHelper.put(LOGIN_KEY, user.id)
    }

    @Throws(Resources.NotFoundException::class, NullPointerException::class)
    fun getLoginUser(): User {
        val loginId = sharedPrefsHelper.get(LOGIN_KEY, -1L)
        return dataManager.getUser(loginId)
    }

    fun logout() {
        sharedPrefsHelper.deleteSavedData(LOGIN_KEY)
    }
}