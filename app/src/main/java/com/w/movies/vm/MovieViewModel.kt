package com.w.movies.vm

import android.util.Log
import androidx.lifecycle.*
import com.w.movies.data.remote.MovieRepository
import com.w.movies.model.Results
import com.w.movies.supporting.Resource
import com.w.movies.supporting.Sorting
import com.w.movies.supporting.Status
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.UnknownHostException

class MovieViewModel(private val repository : MovieRepository) : ViewModel() {




    val reqStatus = MutableLiveData<Resource>()
    private var sortBy = ""
    var movieList  = repository.movies


    fun setSortingRule(sortBy: String){
        this.sortBy = sortBy
    }

    /***
     * THis method will call setSortingRule to set sort for future use
     * **/
    fun loadData(){
        viewModelScope.launch {
                try {
                    reqStatus.postValue(Resource.loading())
                    repository.refreshMovieList(sortBy)
                    reqStatus.postValue(Resource.done())
                } catch (unknownHost: UnknownHostException) {
                    unknownHost.printStackTrace()
                    reqStatus.postValue(Resource.done())
                 } catch (exception: Exception) {
                    reqStatus.postValue(Resource.error(exception.localizedMessage))
                }
            }


    }



}