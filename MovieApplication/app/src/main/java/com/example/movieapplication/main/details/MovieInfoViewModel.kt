package com.example.movieapplication.main.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapplication.additonal.ConnectionFailedException
import com.example.movieapplication.additonal.launchSafe
import com.example.movieapplication.base.ParentViewModel
import com.example.movieapplication.data.models.MovieData
import com.example.movieapplication.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieInfoViewModel(private val movieRepository: MovieRepository) : ParentViewModel() {

    private val _liveData = MutableLiveData<State>()
    val liveData: LiveData<State>
        get() = _liveData

    fun getMovie(movieId: Int) {
        uiScope.launchSafe(::handleError) {
            _liveData.value =
                State.ShowLoading
            withContext(Dispatchers.IO) {
                val movie = movieRepository.getMovieById(movieId)
                movie?.let { movieInfo ->
                    _liveData.postValue(
                        State.Result(
                            movieInfo
                        )
                    )
                }
            }
            _liveData.value =
                State.HideLoading
        }
    }
    fun setFavorite(accountId: Int, movieId: Int, sessionId: String,setFav: Boolean) {
        uiScope.launchSafe(::handleError) {
            withContext(Dispatchers.Default) {
                val resultCode: Int? = movieRepository.rateMovie(movieId, accountId, sessionId, favorite = setFav)
                resultCode?.let { data ->
                    _liveData.postValue(
                        State.FavoriteMovie(
                            data
                        )
                    )
                }
            }

        }
    }

    fun getMovieStatus(accountId: Int, movieId: Int, sessionId: String, setFavState: Boolean) {
        uiScope.launchSafe(::handleError) {
            withContext(Dispatchers.Default) {
                val resultCode: Int? = movieRepository.getState(movieId, accountId, sessionId,setFavState)
                resultCode?.let { data ->
                    _liveData.postValue(
                        State.MovieState(
                            data
                        )
                    )
                }
            }

        }
    }

    override fun handleError(e: Throwable) {
        _liveData.value = State.HideLoading
        if (e is ConnectionFailedException) {
            _liveData.value = State.IntError(e.messageInt)
        } else {
            _liveData.value = State.Error(e.localizedMessage)
        }
    }

    sealed class State {
        object ShowLoading: State()
        object HideLoading: State()
        data class Result(val movie: MovieData): State()
        data class MovieState(val resultCode: Int): State()
        data class FavoriteMovie(val resultCode: Int): State()
        data class Error(val error: String?): State()
        data class IntError(val error: Int): State()
    }
}