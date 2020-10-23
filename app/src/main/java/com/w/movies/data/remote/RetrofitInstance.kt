package com.w.movies.data.remote

import retrofit2.Retrofit
 import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val Base_url = "https://api.themoviedb.org/"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Base_url)
            .build()
    }

    val MoviewApi by lazy {
        retrofitService().create(MoviewApi::class.java)
    }


}