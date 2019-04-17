package com.example.daggerstepbystep.di.main

import android.content.Context
import com.example.daggerstepbystep.MainActivity
import com.example.daggerstepbystep.di.ActivityContext
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

}