package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.data.user.UserRepository
import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.app.user.UserComponent
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.di.main.info.InfoModule
import dagger.Component

@PerActivity
@Component(
    dependencies = [UserComponent::class],
    modules = [MainModule::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    fun getUserRepository(): UserRepository

    fun plus(infoModule: InfoModule): InfoComponent
    fun plus(detail: DetailModule): DetailComponent

}