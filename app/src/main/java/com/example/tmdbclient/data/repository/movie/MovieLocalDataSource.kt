package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {

    fun getMoviesFlowFromDB(): Flow<List<Movie>>
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}