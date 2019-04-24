package com.example.daggerstepbystep.ui.login

import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.data.login.LoginManager
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.ui.main.Navigation
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val view: LoginContract.View,
    private val loginManager: LoginManager,
    private val dataManager: DataManager
): LoginContract.Presenter {
    override fun onSubmit(id: String, password: String) {
        if (id.isEmpty()) view.onError(LoginContract.ErrorType.ID_FORMAT)
        if (password.isEmpty()) view.onError(LoginContract.ErrorType.PASSWORD_INCORRECT)

        loginManager.login(getUser(id, password))

        view.onNavigate(Navigation.OpenMainView)
    }

    private fun getUser(id: String, password: String): User {
        return dataManager.getUser(1)
    }
}