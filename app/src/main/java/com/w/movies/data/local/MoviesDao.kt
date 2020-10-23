package com.w.movies.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.w.movies.model.Results

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(listOfMovies : List<Results>)

    @Query("Select * from movies")
    fun getAllMovies(): LiveData<List<Results>>



    @Query("Delete from movies")
    fun deleteAllMovies()
}