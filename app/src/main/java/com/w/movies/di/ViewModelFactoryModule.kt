package com.w.movies.di

import androidx.lifecycle.ViewModelProvider
import com.w.movies.supporting.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}