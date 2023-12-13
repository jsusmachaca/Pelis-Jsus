package com.example.pelisjsus.repository

import android.annotation.SuppressLint
import com.example.pelisjsus.models.MoviesItem
import com.example.pelisjsus.services.RetrofitSearchInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieSearchRepository {
    private val movieApiService = RetrofitSearchInstance.movieApiService

    @SuppressLint("CheckResult")
    fun searchMovie(title: String, onResult: (MoviesItem) -> Unit) {
        movieApiService.searchMovies(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movieResponse ->
                    onResult(movieResponse)
                },
                { error ->
                    // Handle error if needed
                }
            )
    }
}