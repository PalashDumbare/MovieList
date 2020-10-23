package com.w.movies.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.w.movies.BuildConfig
import com.w.movies.data.local.MoviesDao
import com.w.movies.model.MovieList
import com.w.movies.model.Results
import com.w.movies.supporting.Sorting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.reflect.Constructor
import javax.inject.Inject


class MovieRepository @Inject constructor(private val moviewApi: MoviewApi,private val moviesDao: MoviesDao) {


    private val TAG : String  = MovieRepository::class.java.simpleName

    var movies  = moviesDao.getAllMovies()

    suspend fun refreshMovieList(sortBy : String) {
        val rep = moviewApi.getMovies(BuildConfig.API_KEY,sortBy)
        withContext(Dispatchers.IO) {
            if (movies.value?.isNotEmpty()?: true) {
                moviesDao.deleteAllMovies()
            }
            moviesDao.insertAllMovies(rep.results)
        }
    }




}