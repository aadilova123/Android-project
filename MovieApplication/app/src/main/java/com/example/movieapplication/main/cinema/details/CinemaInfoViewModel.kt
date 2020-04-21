package com.example.movieapplication.main.cinema.details
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.data.repositoryIMPL.CinemaRepositoryImpl
import com.example.movieapplication.data.roomCinema.Cinema
import com.example.movieapplication.data.roomCinema.CinemaRoomDatabase
import com.example.movieapplication.repository.CinemaRepository
import kotlinx.coroutines.launch

class CinemaInfoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CinemaRepository

    lateinit var liveData: LiveData<Cinema>

    init {
        val cinemaDao = CinemaRoomDatabase.getDatabase(application, viewModelScope).cinemaDao()
        repository = CinemaRepositoryImpl(cinemaDao)
    }

    fun getCinema(id: Int) {
        viewModelScope.launch {
            val cinema = repository.getCinema(id)
            cinema.let { cinema->
                liveData = cinema
            }
        }
    }
}