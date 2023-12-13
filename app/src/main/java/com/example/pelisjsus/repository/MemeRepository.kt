package com.example.pelisjsus.repository

import com.example.pelisjsus.models.Memes
import com.example.pelisjsus.services.RetrofitInstance

class MemeRepository {
    private val memeService = RetrofitInstance.memeService

        suspend fun getMeme(): Memes {
            return memeService.getMeme()
        }
}