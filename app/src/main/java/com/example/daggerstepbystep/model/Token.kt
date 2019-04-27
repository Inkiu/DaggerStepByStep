package com.example.daggerstepbystep.model

data class Token(
    val accessToken: String,
    val refreshToken: String
) {
    fun isValid(): Boolean {
        return accessToken.isNotEmpty() && refreshToken.isNotEmpty()
    }
}