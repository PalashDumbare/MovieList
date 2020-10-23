package com.w.movies.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.w.movies.R
import com.w.movies.interfaces.ImageSetListener
import com.w.movies.model.Results
import com.w.movies.supporting.DateUtils
import com.w.movies.supporting.Utils
import com.w.movies.supporting.baseURlForImage_w154
import com.w.movies.supporting.baseURlForImage_w780
import kotlinx.android.synthetic.main.movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var movieDetails : Results

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        receiveData()
        showDetails()
    }

    fun receiveData(){
        movieDetails = intent.getParcelableExtra<Results>("movie")
    }


    /***
     * There are many movies fro which backdrop or poster or both are null,hence we will show movie title
     * instead of image
     * */
    fun showDetails(){

        if (movieDetails.poster_path.isNullOrEmpty()){
             postertitle.visibility = View.VISIBLE
             postertitle.setText(movieDetails.title)
         }else{
            postertitle.visibility = View.GONE
            posterImage.visibility = View.VISIBLE
            Utils.loadImage(ctx = this, uri = baseURlForImage_w154+movieDetails.poster_path, imageView = posterImage)

        }

        if (movieDetails.backdrop_path.isNullOrEmpty()) {
            bannertitle.visibility = View.VISIBLE
            bannertitle.setText(movieDetails.title)
            backDropShimmer.stopShimmerAnimation()
        }else{
             bannertitle.visibility = View.GONE
             Utils.loadImage(ctx = this, uri = baseURlForImage_w780 + movieDetails.backdrop_path, imageView = backDropImage)
         }

        txttitle.setText(movieDetails.title)
        txtOverivew.setText(movieDetails.overview)
        txtReleaseDate.setText(DateUtils.convertDate(movieDetails.release_date,"yyyy-MM-dd","dd/MM/yyyy"))
        txtRating.setText(movieDetails.vote_average.toString())
    }
}