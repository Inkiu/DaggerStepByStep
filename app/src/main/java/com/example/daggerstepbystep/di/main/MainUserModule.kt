package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.ui.main.MainContract
import com.example.daggerstepbystep.ui.main.MainPresenter
import com.example.daggerstepbystep.ui.main.user.MainUserFragment
import dagger.Module
import dagger.Provides

@Module
class MainUserModule(
    private val fragment: MainUserFragment
) {

    @Provides
    fun provideMainView(): MainContract.View = fragment

    @Provides
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter

}