package com.w.movies.supporting

 class Sorting {
     companion object{
         fun byDate() : Pair<String, String> = Pair("release.date.asc","release_date")
         fun byRating():Pair<String,String> = Pair("vote.average.asc","vote_average")
     }
}