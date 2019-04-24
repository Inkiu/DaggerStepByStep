package com.example.daggerstepbystep.ui.login

interface LoginContract {
    interface View {
        fun onError(error: ErrorType)
    }

    interface Presenter {
        fun onSubmit(id: String, password: String)
    }

    enum class ErrorType {
        ID_FORMAT, PASSWORD_INCORRECT
    }
}