package com.example.daggerstepbystep.ui.main

interface MainContract {
    interface View {
        fun onRestartApp()
    }

    interface Presenter {
        fun onLogout()
    }
}