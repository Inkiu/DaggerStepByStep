package com.example.daggerstepbystep.di.main

import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.di.PerLogin
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.di.main.info.InfoModule
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerLogin
@Subcomponent(
    modules = [
        AndroidSupportInjectionModule::class,
        FragmentBuilder::class,
        MainModule::class
    ]
)
interface MainComponent : AndroidInjector<MainActivity> {
}