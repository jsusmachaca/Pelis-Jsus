package com.example.pelisjsus.services

import com.example.pelisjsus.models.Movies
import retrofit2.http.GET

interface MovieService {
    @GET("/")
    suspend fun getMovie(): Movies
}