package com.example.daggerstepbystep.di.app

import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.di.login.LoginModule
import com.example.daggerstepbystep.di.main.MainFragmentBuilder
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @PerActivity
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentBuilder::class])
    @PerActivity
    abstract fun bindMainActivity(): MainActivity

}