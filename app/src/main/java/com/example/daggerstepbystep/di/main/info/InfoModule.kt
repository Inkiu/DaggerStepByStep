package com.example.daggerstepbystep.di.main.info

import com.example.daggerstepbystep.ui.user.InfoContract
import com.example.daggerstepbystep.ui.user.InfoFragment
import com.example.daggerstepbystep.ui.user.InfoPresenter
import dagger.Module
import dagger.Provides

@Module
class InfoModule(
    private val fragment: InfoFragment
) {
    @Provides
    fun provideInfoView(): InfoContract.View = fragment

    @Provides
    fun provideInfoPresenter(presenter: InfoPresenter): InfoContract.Presenter = presenter

}