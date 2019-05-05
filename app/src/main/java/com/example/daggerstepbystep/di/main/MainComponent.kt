package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.di.PerLogin
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.di.main.info.InfoModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerLogin
@Subcomponent(modules = [MainModule::class])
interface MainComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        abstract fun mainModule(module: MainModule)

        override fun seedInstance(instance: MainActivity) {
            mainModule(MainModule(instance))
        }
    }

    fun plus(infoModule: InfoModule): InfoComponent
    fun plus(detail: DetailModule): DetailComponent

}