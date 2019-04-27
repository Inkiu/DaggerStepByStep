package com.example.daggerstepbystep.di.main

import android.content.Context
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.ActivityContext
import com.example.daggerstepbystep.ui.main.MainContract
import com.example.daggerstepbystep.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule(
    private val activity: MainActivity
) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): MainActivity = activity

    @Provides
    fun provideMainView(): MainContract.View = activity

    @Provides
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter

}