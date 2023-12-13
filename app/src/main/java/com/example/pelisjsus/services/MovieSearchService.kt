package com.example.pelisjsus.services

import com.example.pelisjsus.models.Movies
import com.example.pelisjsus.models.MoviesItem
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchService {
    @GET("/search")
    suspend fun searchMovie(@Query("titulo") title: String): MoviesItem
}