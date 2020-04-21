package com.example.movieapplication.main.cinema
import androidx.lifecycle.LiveData
import com.example.movieapplication.additonal.ConnectionFailedException
import com.example.movieapplication.base.ParentViewModel
import com.example.movieapplication.data.repositoryIMPL.CinemaRepositoryImpl
import com.example.movieapplication.data.roomCinema.Cinema
import com.example.movieapplication.data.roomCinema.CinemaDao
import com.example.movieapplication.repository.CinemaRepository

class CinemaViewModel(private val cinemaDao: CinemaDao) : ParentViewModel() {

    private val repository: CinemaRepository

    var liveData: LiveData<List<Cinema>>

    init {

        repository = CinemaRepositoryImpl(cinemaDao)
        liveData = repository.getAllCinemas()
    }
    override fun handleError(e: Throwable) {
        if (e is ConnectionFailedException) {
            //ToDo
        }
    }
}