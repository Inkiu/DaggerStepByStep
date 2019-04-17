package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.main.user.MainUserFragment
import dagger.Component

@PerFragment
@Component(
    dependencies = [MainComponent::class],
    modules = [MainUserModule::class]
)
interface MainUserComponent {

    fun inject(fragment: MainUserFragment)

}