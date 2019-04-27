package com.example.daggerstepbystep.data.login

import android.content.Context
import android.content.SharedPreferences
import com.example.daggerstepbystep.di.ApplicationContext
import com.example.daggerstepbystep.model.Token
import javax.inject.Inject

class UserProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val SP_KEY_LOGIN_ID = "login_id"
        const val SP_KEY_LOGIN_PW = "login_pw"
        const val SP_KEY_ACCESS_TOKEN = "access_token"
        const val SP_KEY_REFRESH_TOKEN = "refresh_token"
    }
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("login_provider_sp", Context.MODE_PRIVATE)
    }

    fun getLoginToken(): Token {
        return Token(
            sharedPreferences.getString(SP_KEY_ACCESS_TOKEN, "") ?: "",
            sharedPreferences.getString(SP_KEY_REFRESH_TOKEN, "") ?: ""
        )
    }

    fun setLoginToken(token: Token) {
        sharedPreferences.edit().apply {
            putString(SP_KEY_ACCESS_TOKEN, token.accessToken)
            putString(SP_KEY_REFRESH_TOKEN, token.refreshToken)
        }.apply()
    }

    fun clearLoginToken() {
        sharedPreferences.edit().clear().apply()
    }
}