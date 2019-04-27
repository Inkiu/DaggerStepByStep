package com.example.daggerstepbystep.data.login

import android.content.Context
import com.example.daggerstepbystep.di.ApplicationContext
import com.example.daggerstepbystep.model.Token
import javax.inject.Inject

class LoginManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userProvider: UserProvider
) {
    fun login(id: String, password: String): Boolean {
        // login api call
        val success = id == "id" && password == "password"
        if (success) {
            userProvider.setLoginToken(Token("Ok Access", "Ok Refresh"))
        } else {
            /* no-op */
        }
        return success
    }
}