package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.ApplicationComponent
import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.ui.main.MainContract
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    fun plus(mainUserModule: MainUserModule): MainUserComponent

}