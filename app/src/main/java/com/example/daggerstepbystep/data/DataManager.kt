package com.example.daggerstepbystep.data

import android.content.Context
import android.content.res.Resources
import javax.inject.Singleton
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.di.ApplicationContext
import javax.inject.Inject


@Singleton
class DataManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val dbHelper: DbHelper,
    private val sharedPrefsHelper: SharedPrefsHelper
) {

    fun getAccessToken(): String {
        return sharedPrefsHelper.get(PREF_KEY_ACCESS_TOKEN, "")
    }

    fun saveAccessToken(accessToken: String) {
        sharedPrefsHelper.put(PREF_KEY_ACCESS_TOKEN, accessToken)
    }

    @Throws(Exception::class)
    fun createUser(user: User): Long {
        return dbHelper.insertUser(user)
    }

    @Throws(Resources.NotFoundException::class, NullPointerException::class)
    fun getUser(userId: Long?): User {
        if (userId == -1L) throw Resources.NotFoundException("Requested login id is not valid")
        return dbHelper.getUser(userId!!)
    }
}