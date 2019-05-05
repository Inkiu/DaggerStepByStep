package com.example.daggerstepbystep.ui.main

interface MainContract {
    interface View {
        fun onNavigate(navigation: Navigation)
        fun onRestartApp()
    }

    interface Presenter {
        fun onCreate()
        fun onLogout()
    }
}