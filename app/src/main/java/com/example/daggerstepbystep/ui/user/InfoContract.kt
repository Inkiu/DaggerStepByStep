package com.example.daggerstepbystep.ui.user

import com.example.daggerstepbystep.model.User

interface InfoContract {
    interface View {
        fun onBindInfo(user: User)
    }

    interface Presenter {
        fun onCreate()
    }
}