package com.example.pelisjsus.repository

import com.example.pelisjsus.models.Movies
import com.example.pelisjsus.models.MoviesItem
import com.example.pelisjsus.services.MovieSearchService
import retrofit2.HttpException

class MovieSearchRepository(private val movieSearchService: MovieSearchService) {
    suspend fun searchMovie(title: String): Result<MoviesItem> {
        return try {
            val result: MoviesItem = movieSearchService.searchMovie(title)
            Result.success(result)
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}