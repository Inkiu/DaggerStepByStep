package com.example.daggerstepbystep.ui.main

sealed class Navigation {
    object LoginView : Navigation()
    object OpenMainView : Navigation()
}