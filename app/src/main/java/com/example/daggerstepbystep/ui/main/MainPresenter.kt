package com.example.daggerstepbystep.ui.main

import com.example.daggerstepbystep.data.DataManager
import javax.inject.Inject


class MainPresenter @Inject constructor(
    private val view: MainContract.View,
    private val dataManager: DataManager
) : MainContract.Presenter {

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}