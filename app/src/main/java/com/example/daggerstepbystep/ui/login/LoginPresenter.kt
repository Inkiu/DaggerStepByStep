package com.example.daggerstepbystep.ui.login

import com.example.daggerstepbystep.data.login.LoginManager
import com.example.daggerstepbystep.ui.main.Navigation
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val view: LoginContract.View,
    private val loginManager: LoginManager
): LoginContract.Presenter {
    override fun onSubmit(id: String, password: String) {
        if (id.isEmpty()) view.onError(LoginContract.ErrorType.ID_FORMAT)
        if (password.isEmpty()) view.onError(LoginContract.ErrorType.PASSWORD_INCORRECT)

        if (loginManager.login(id, password)) {
            view.onNavigate(Navigation.OpenMainView)
        } else {
            view.onError(LoginContract.ErrorType.PASSWORD_INCORRECT)
        }
    }
}