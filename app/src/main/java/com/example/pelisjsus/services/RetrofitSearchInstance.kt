package com.example.pelisjsus.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSearchInstance {
    private const val BASE_URL = "http://172.22.149.102:5000"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val movieService: MovieSearchService by lazy {
        retrofit.create(MovieSearchService::class.java)
    }
}
