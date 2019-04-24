package com.example.daggerstepbystep.ui.user

import com.example.daggerstepbystep.model.User

interface UserContract {
    interface View {
        fun onBindUser(user: User)
        fun onBindAccessToken(token: String)
    }

    interface Presenter {
        fun onCreate()
    }
}