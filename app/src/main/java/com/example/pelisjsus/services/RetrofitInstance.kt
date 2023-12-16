package com.example.pelisjsus.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://androapi-dev-ggte.4.us-1.fl0.io"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val memeService: MemeService by lazy {
        retrofit.create(MemeService::class.java)
    }
}