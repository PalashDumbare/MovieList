package com.w.movies.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
 import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule


import javax.inject.Singleton


/*@Component.Builder: We might want to bind some instance to Component.
 In this case we can create an interface with @Component.
 Builder annotation and add whatever method we want to add to builder.

 */
@Singleton
@Component(modules = [AppModule::class,
    AndroidInjectionModule::class,
    ActivityBuilder::class,
ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<DaggerApplication?> {
    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }
}