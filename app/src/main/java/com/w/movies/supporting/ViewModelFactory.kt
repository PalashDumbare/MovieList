package  com.w.movies.supporting

 import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
 import com.w.movies.data.local.MoviesDao
 import com.w.movies.data.remote.MovieRepository
 import com.w.movies.vm.MovieViewModel
 import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: MovieRepository,private val moviesDao: MoviesDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}