package com.example.daggerstepbystep.di.app

import com.example.daggerstepbystep.di.login.LoginModule
import com.example.daggerstepbystep.di.main.FragmentBuilder
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [MainModule::class, FragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity

}