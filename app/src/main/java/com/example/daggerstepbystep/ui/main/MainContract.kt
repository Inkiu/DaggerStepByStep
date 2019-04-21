package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.model.User

interface MainContract {
    interface View {
        fun onBindUser(user: User)
        fun onBindToken(token: String)

        fun onNavigateDetail()
    }

    interface Presenter {
        fun onCreate()

        fun onRequestDetail()
    }
}