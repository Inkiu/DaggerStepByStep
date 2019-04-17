package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.main.user.MainUserFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(
    modules = [MainUserModule::class]
)
interface MainUserComponent {

    fun inject(fragment: MainUserFragment)

}