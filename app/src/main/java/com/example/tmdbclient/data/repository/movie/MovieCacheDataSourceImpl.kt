package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.model.Movie
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieCacheDataSourceImpl @Inject constructor(): MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> = movieList

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}