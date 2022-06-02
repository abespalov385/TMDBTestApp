package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.MovieList
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSourceImpl @Inject constructor(private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}