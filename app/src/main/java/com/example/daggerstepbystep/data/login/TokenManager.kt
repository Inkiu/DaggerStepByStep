package com.example.daggerstepbystep.data.login

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(
    private val tokenSP: TokenSharedPref
) {
    fun putToken(accessToken: String, refreshToken: String) {
        tokenSP.putAccessToken(accessToken)
        tokenSP.putRefreshToken(refreshToken)
    }

    fun updateAccessToken(accessToken: String) {
        tokenSP.putAccessToken(accessToken)
    }

    fun getAccessToken(): String {
        return tokenSP.getAccessToken()
    }

    fun getRefreshToken(): String {
        return tokenSP.getRefreshToken()
    }
}