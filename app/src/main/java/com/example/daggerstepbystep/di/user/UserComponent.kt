package com.example.daggerstepbystep.di.user

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.user.UserFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(
    modules = [UserModule::class]
)
interface UserComponent {
    fun inject(userFragment: UserFragment)
}