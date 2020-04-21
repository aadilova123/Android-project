package com.example.movieapplication.repository

import androidx.lifecycle.LiveData
import com.example.movieapplication.data.roomCinema.Cinema

interface CinemaRepository {

    fun getAllCinemas(): LiveData<List<Cinema>>

    fun getCinema(id: Int): LiveData<Cinema>
}