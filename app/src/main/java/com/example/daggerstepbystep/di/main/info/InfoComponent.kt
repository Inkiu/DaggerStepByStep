package com.example.daggerstepbystep.di.main.info

import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.user.InfoFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@PerFragment
@Subcomponent(modules = [InfoModule::class])
interface InfoComponent : AndroidInjector<InfoFragment> {
}