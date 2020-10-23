package com.w.movies.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.w.movies.ApplicationStartUp
import com.w.movies.data.local.MoviesDao
import com.w.movies.data.remote.MovieRepository
import com.w.movies.data.remote.MoviewApi
import com.w.movies.data.remote.RetrofitInstance

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {


    @Provides
    @Singleton
    fun provideApplication(app: Application): Context = app


    @Provides
    fun provideMovieService(): MoviewApi {
        return RetrofitInstance.MoviewApi
    }

    @Provides
    @Singleton
    fun provideMoviewRepo(service: MoviewApi,moviesDao: MoviesDao) = MovieRepository(service,moviesDao)


    @Provides
    @Singleton
    fun provideMovieDao(): MoviesDao = ApplicationStartUp.db?.moviesDao()!!
}