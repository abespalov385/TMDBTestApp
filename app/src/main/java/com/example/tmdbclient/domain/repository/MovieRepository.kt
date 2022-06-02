package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}