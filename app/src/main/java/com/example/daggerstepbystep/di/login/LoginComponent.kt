package com.example.daggerstepbystep.di.login

import com.example.daggerstepbystep.di.PerFragment
import com.example.daggerstepbystep.ui.login.LoginFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(
    modules = [LoginModule::class]
)
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}