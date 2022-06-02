package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.Movie
import javax.inject.Singleton

@Singleton
interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}