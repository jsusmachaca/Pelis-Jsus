package com.example.pelisjsus.services

import com.example.pelisjsus.models.MoviesItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSearchService {
    @GET("/search")
    fun searchMovies(@Query("titulo") titulo: String): Single<MoviesItem>
}