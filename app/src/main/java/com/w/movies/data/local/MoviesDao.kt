package com.w.movies.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
 import com.w.movies.model.Results


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies(listOfMovies : List<Results>)

    @Query("Select * from movies")
    fun getAllMovies(): LiveData<List<Results>>

    @RawQuery(observedEntities = [Results::class])
    fun getSortedMovies(query: SupportSQLiteQuery?): LiveData<List<Results>>

    @Query("Delete from movies")
    fun deleteAllMovies()
}