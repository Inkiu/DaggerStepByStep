package com.example.daggerstepbystep.di.main.info

import com.example.daggerstepbystep.ui.user.InfoContract
import com.example.daggerstepbystep.ui.user.InfoFragment
import com.example.daggerstepbystep.ui.user.InfoPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class InfoModule {

    @Binds
    abstract fun provideInfoView(infoFragment: InfoFragment): InfoContract.View

    @Binds
    abstract fun provideInfoPresenter(presenter: InfoPresenter): InfoContract.Presenter

}