package com.example.daggerstepbystep.di.detail

import android.content.Context
import com.example.daggerstepbystep.data.UserRepository
import com.example.daggerstepbystep.di.ActivityContext
import com.example.daggerstepbystep.ui.detail.DetailActivity
import com.example.daggerstepbystep.ui.detail.DetailContract
import com.example.daggerstepbystep.ui.detail.DetailPresenter
import dagger.Module
import dagger.Provides

@Module
class DetailModule(
    private val activity: DetailActivity
) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): DetailActivity = activity

    @Provides
    fun provideView(): DetailContract.View = activity

    @Provides
    fun providePresenter(presenter: DetailPresenter): DetailContract.Presenter = presenter

}