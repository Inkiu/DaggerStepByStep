package com.example.daggerstepbystep.di.main

import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.ui.detail.DetailFragment
import com.example.daggerstepbystep.ui.user.InfoFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        InfoComponent::class,
        DetailComponent::class
    ]
)
abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(InfoFragment::class)
    abstract fun bindInfoFragment(builder: InfoComponent.Builder): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(DetailFragment::class)
    abstract fun bindDetailFragment(builder: DetailComponent.Builder): AndroidInjector.Factory<out Fragment>

}