package com.example.pelisjsus.services

import com.example.pelisjsus.models.Memes
import retrofit2.http.GET

interface MemeService {
    @GET("/")
    suspend fun getMeme(): Memes
}