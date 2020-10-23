package com.w.movies.di

 import com.w.movies.ui.MovieListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMovieList(): MovieListActivity?

}