package com.example.daggerstepbystep.ui.login

import com.example.daggerstepbystep.ui.main.Navigation

interface LoginContract {
    interface View {
        fun onNavigate(navigation: Navigation)
        fun onError(error: ErrorType)
    }

    interface Presenter {
        fun onSubmit(id: String, password: String)
    }

    enum class ErrorType {
        ID_FORMAT, PASSWORD_INCORRECT
    }
}