package com.example.daggerstepbystep.di.main

import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoModule
import com.example.daggerstepbystep.ui.detail.DetailFragment
import com.example.daggerstepbystep.ui.user.InfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [InfoModule::class])
    abstract fun bindInfoFragment(): InfoFragment

    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindDetailFragment(): DetailFragment

}