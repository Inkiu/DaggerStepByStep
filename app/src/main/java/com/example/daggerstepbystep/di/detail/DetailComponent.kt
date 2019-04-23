package com.example.daggerstepbystep.di.detail

import com.example.daggerstepbystep.di.PerActivity
import com.example.daggerstepbystep.ui.detail.DetailActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(
    modules = [DetailModule::class]
)
interface DetailComponent {

    fun inject(detailActivity: DetailActivity)

}