package com.example.daggerstepbystep.ui.detail

import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.model.UserDetail

interface DetailContract {
    interface View {
        fun onBindInfo(userDetail: UserDetail)
    }

    interface Presenter {
        fun onCreate()
    }
}