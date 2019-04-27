package com.example.daggerstepbystep.di.main.info

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.user.InfoFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [InfoModule::class])
interface InfoComponent {
    fun inject(fragment: InfoFragment)
}