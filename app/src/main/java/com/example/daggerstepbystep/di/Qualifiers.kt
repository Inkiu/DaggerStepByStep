package com.example.daggerstepbystep.di

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseInfo

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerLogin

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment