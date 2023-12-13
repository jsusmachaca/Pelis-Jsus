package com.example.pelisjsus.repository

import android.annotation.SuppressLint
import com.example.pelisjsus.models.MemesItem
import com.example.pelisjsus.services.RetrofitSearchInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MemeSearchRepository {
    private val memeApiService = RetrofitSearchInstance.memeApiService

    @SuppressLint("CheckResult")
    fun searchMeme(title: String, onResult: (MemesItem) -> Unit) {
        memeApiService.searchMemes(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { memeResponse ->
                    onResult(memeResponse)
                },
                { error ->
                    // Handle error if needed
                }
            )
    }
}