package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.MainActivity
import com.example.daggerstepbystep.di.ApplicationComponent
import com.example.daggerstepbystep.di.PerActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

}