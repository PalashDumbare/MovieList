package com.w.movies.data.remote

import com.w.movies.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviewApi {


    @GET("3/discover/movie")
    suspend fun getMovies(@Query("api_key")api : String,@Query("sort_by")sort_by : String) : MovieList


}