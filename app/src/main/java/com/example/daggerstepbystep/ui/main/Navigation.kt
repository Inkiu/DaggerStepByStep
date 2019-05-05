package com.example.daggerstepbystep.ui.main

sealed class Navigation {
    object OpenLogin : Navigation()
    object OpenMainView : Navigation()
}