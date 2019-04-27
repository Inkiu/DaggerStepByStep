package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.app.user.UserComponent
import dagger.Component

@PerActivity
@Component(
    dependencies = [UserComponent::class],
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

}