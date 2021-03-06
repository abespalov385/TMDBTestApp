package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}