package com.w.movies.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies")
@Parcelize
data class Results (

		@ColumnInfo(name = "popularity")val popularity : Double,
		@ColumnInfo(name = "poster_path")val poster_path : String?,
		@PrimaryKey val id : Int,
		@ColumnInfo(name =  "backdrop_path")val backdrop_path : String?,
		@ColumnInfo(name =  "original_language")val original_language : String,
		@ColumnInfo(name =  "title")val title : String,
		@ColumnInfo(name =  "vote_average")val vote_average : Double,
		@ColumnInfo(name =  "overview")val overview : String,
		@ColumnInfo(name =  "release_date")val release_date : String
) : Parcelable