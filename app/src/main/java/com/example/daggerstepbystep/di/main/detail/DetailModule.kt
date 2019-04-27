package com.example.daggerstepbystep.di.main.detail

import com.example.daggerstepbystep.ui.detail.DetailContract
import com.example.daggerstepbystep.ui.detail.DetailFragment
import com.example.daggerstepbystep.ui.detail.DetailPresenter
import dagger.Module
import dagger.Provides

@Module
class DetailModule(
    private val fragment: DetailFragment
) {
    @Provides
    fun provideDetailView(): DetailContract.View = fragment

    @Provides
    fun provideDetailPresenter(presenter: DetailPresenter): DetailContract.Presenter = presenter
}