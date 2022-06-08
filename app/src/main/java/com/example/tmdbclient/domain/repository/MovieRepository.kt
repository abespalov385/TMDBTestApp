package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<List<Movie>>
    suspend fun updateMovies()
}