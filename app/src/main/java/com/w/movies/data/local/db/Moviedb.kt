package com.w.movies.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.w.movies.data.local.MoviesDao
import com.w.movies.model.Results

@Database(entities = [Results::class],version = 1)
abstract class Moviedb  : RoomDatabase() {
    abstract fun moviesDao() : MoviesDao
}