package com.w.movies.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.w.movies.R
import com.w.movies.interfaces.ItemClickListener
import com.w.movies.model.Results
import com.w.movies.supporting.Sorting
import com.w.movies.supporting.Status
import com.w.movies.supporting.ViewModelFactory
import com.w.movies.vm.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MovieListActivity : BaseActivity(),ItemClickListener<Results> {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var  movieViewModel: MovieViewModel

    private lateinit var  adapter : MoviesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializations()
        observeViewModel()
     }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.sortmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.rating ->{

                if (this.isConnectedToNetwork()) {
                    movieViewModel.setSortingRule(Sorting.byRating().first)
                    movieViewModel.loadData()
                }else{
                    movieViewModel.setSortingRule(Sorting.byRating().second)
                    movieViewModel.sort()
                    observeSortedMovies()
                }
                true
            }
            R.id.releasedate->{
                if (this.isConnectedToNetwork()) {
                    movieViewModel.setSortingRule(Sorting.byDate().first)
                    movieViewModel.loadData()
                }else{
                    movieViewModel.setSortingRule(Sorting.byDate().second)
                    movieViewModel.sort()
                    observeSortedMovies()
                }
                true
            }



            else -> super.onOptionsItemSelected(item)
        }
    }

    fun observeSortedMovies(){
        movieViewModel.sort().observe(this, Observer {
             adapter.swapValue(it)
        })
    }

    fun initializations(){
        adapter = MoviesAdapter(this)
        movieList.layoutManager = GridLayoutManager(this,2)
        movieList.adapter = adapter
        movieViewModel =  ViewModelProviders.of(this,viewModelFactory).get(MovieViewModel::class.java)
        movieViewModel.setSortingRule(Sorting.byRating().first)
    }



    fun observeMovieList(){
        movieViewModel.movieList.observe(this, Observer {
            adapter.swapValue(it)
        })

    }



    fun observeViewModel(){


        movieViewModel.loadData()
        observeMovieList()


        movieViewModel.reqStatus.observe(this, Observer {

             when(it.status){
                Status.Loading -> this.showLoading()
                Status.Success -> this.hideLoading()
                Status.Error -> this.showMessage(it.message?:getString(R.string.somethingwentwrong))

            }
        })

    }



    override fun onItemClick(movie: Results) {
        val intent = Intent(this,MovieDetailsActivity::class.java)
        intent.putExtra("movie",movie)
        startActivity(intent)
    }
}