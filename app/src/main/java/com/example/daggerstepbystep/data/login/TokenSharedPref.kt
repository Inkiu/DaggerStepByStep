package com.example.daggerstepbystep.data.login

import android.content.Context
import android.content.SharedPreferences
import com.example.daggerstepbystep.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenSharedPref @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object {
        const val ACCESS_KEY = "access_token"
        const val REFRESH_KEY = "refresh_token"
    }
    private val sp: SharedPreferences = context.getSharedPreferences("token_sp", Context.MODE_PRIVATE)

    fun putAccessToken(access: String) {
        sp.edit().putString(ACCESS_KEY, access).apply()
    }

    fun putRefreshToken(refresh: String) {
        sp.edit().putString(REFRESH_KEY, refresh).apply()
    }

    fun getAccessToken(): String {
        val defaultValue = ""
        return sp.getString(ACCESS_KEY, defaultValue) ?: defaultValue
    }

    fun getRefreshToken(): String {
        val defaultValue = ""
        return sp.getString(REFRESH_KEY, defaultValue) ?: defaultValue
    }
}