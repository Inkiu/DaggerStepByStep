package com.example.daggerstepbystep.di.user

import com.example.daggerstepbystep.ui.user.UserContract
import com.example.daggerstepbystep.ui.user.UserFragment
import com.example.daggerstepbystep.ui.user.UserPresenter
import dagger.Module
import dagger.Provides

@Module
class UserModule(
    private val userFragment: UserFragment
) {
    @Provides
    fun provideUserView(): UserContract.View = userFragment

    @Provides
    fun provideUserPresenter(presenter: UserPresenter): UserContract.Presenter = presenter
}