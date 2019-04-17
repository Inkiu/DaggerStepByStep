package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.model.User
import java.lang.Exception
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val dataManager: DataManager
) : MainContract.Presenter {

    override fun onCreate() {
        createUser("Ali", "1367, Gurgaon, Haryana, India")
        view.onBindUser(getUser())
        saveAccessToken("ASDR12443JFDJF43543J543H3K543")
        view.onBindToken(getAccessToken())
    }

    private fun createUser(name: String, address: String) {
        try {
            dataManager.createUser(User(name = name, address = address))
        } catch (e: Exception) {
            // TODO
        }
    }

    private fun getUser(): User {
        return try {
            dataManager.getUser(1L)
        } catch (e: Exception) {
            User(name = "", address = "")
        }
    }

    private fun saveAccessToken(token: String) {
        dataManager.saveAccessToken(token)
    }

    private fun getAccessToken(): String {
        return dataManager.getAccessToken()
    }

}