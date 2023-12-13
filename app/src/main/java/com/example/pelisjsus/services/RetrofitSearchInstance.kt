package com.example.pelisjsus.services

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSearchInstance {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://172.22.149.210:5000")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val memeApiService = retrofit.create(MemeSearchService::class.java)

}