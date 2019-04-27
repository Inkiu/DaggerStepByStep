package com.example.daggerstepbystep.di.app.user

import com.example.daggerstepbystep.data.login.LogoutManager
import com.example.daggerstepbystep.data.user.UserRepository
import com.example.daggerstepbystep.di.PerLogin
import dagger.Subcomponent

@PerLogin
@Subcomponent(modules = [UserModule::class])
interface UserComponent {
    fun getUserRepository(): UserRepository
    fun getLogoutManager(): LogoutManager
}