package com.example.daggerstepbystep.di.main.detail

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.detail.DetailFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {
    fun inject(fragment: DetailFragment)
}