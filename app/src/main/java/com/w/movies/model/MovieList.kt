package com.w.movies.model


data class MovieList (

	val page : Int,
	val total_results : Int,
	val total_pages : Int,
	val results : List<Results>
)