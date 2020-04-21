package com.example.movieapplication.data.repositoryIMPL

import androidx.lifecycle.LiveData
import com.example.movieapplication.data.roomCinema.Cinema
import com.example.movieapplication.data.roomCinema.CinemaDao
import com.example.movieapplication.repository.CinemaRepository


class CinemaRepositoryImpl(private val cinemaDao: CinemaDao) : CinemaRepository {

    override fun getAllCinemas(): LiveData<List<Cinema>> = cinemaDao.getCinemas()

    override fun getCinema(id: Int): LiveData<Cinema> = cinemaDao.getCinema(id)
}