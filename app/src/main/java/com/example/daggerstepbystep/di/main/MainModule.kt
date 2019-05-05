package com.example.daggerstepbystep.di.main

import android.content.Context
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.ActivityContext
import com.example.daggerstepbystep.ui.main.MainContract
import com.example.daggerstepbystep.ui.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule {

    @Binds
    @ActivityContext
    abstract fun provideContext(mainActivity: MainActivity): Context

    @Binds
    abstract fun provideMainView(mainActivity: MainActivity): MainContract.View

    @Binds
    abstract fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter

}