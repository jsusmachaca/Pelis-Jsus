package com.example.pelisjsus.repository

import com.example.pelisjsus.models.Movies
import com.example.pelisjsus.services.RetrofitInstance

class MovieRepository {
    private val movieService = RetrofitInstance.movieService

        suspend fun getMovie(): Movies {
            return movieService.getMovie()
        }
}