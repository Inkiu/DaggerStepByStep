package com.example.daggerstepbystep.di.main

import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.di.app.login.LoginModule
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.di.main.info.InfoModule
import com.example.daggerstepbystep.ui.detail.DetailFragment
import com.example.daggerstepbystep.ui.user.InfoFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [InfoModule::class])
    abstract fun bindInfoFragment(): InfoFragment

    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindDetailFragment(): DetailFragment

}