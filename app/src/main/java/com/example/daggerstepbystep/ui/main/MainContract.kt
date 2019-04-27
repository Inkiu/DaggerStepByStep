package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.model.User

interface MainContract {
    interface View {
        fun onBindUser(user: User)
    }

    interface Presenter {
        fun onCreate()
    }
}