package com.example.daggerstepbystep.ui.detail

import com.example.daggerstepbystep.model.UserDetail

interface DetailContract {
    interface View {
        fun onBindDetail(userDetail: UserDetail)
    }

    interface Presenter {
        fun onCreate()
    }
}