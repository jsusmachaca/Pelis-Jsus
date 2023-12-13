package com.example.pelisjsus.services

import com.example.pelisjsus.models.MemesItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MemeSearchService {
    @GET("/search")
    fun searchMemes(@Query("title") title: String): Single<MemesItem>
}