package com.example.daggerstepbystep.di.main.detail

import com.example.daggerstepbystep.ui.detail.DetailContract
import com.example.daggerstepbystep.ui.detail.DetailFragment
import com.example.daggerstepbystep.ui.detail.DetailPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DetailModule {
    @Binds
    abstract fun provideDetailView(detailFragment: DetailFragment): DetailContract.View

    @Binds
    abstract fun provideDetailPresenter(presenter: DetailPresenter): DetailContract.Presenter
}