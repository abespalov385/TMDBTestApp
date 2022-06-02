package com.example.tmdbclient.data.repository.movie

import com.example.tmdbclient.data.db.MoviesDao
import com.example.tmdbclient.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieLocalDataSourceImpl @Inject constructor(private val moviesDao: MoviesDao): MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = moviesDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteAllMovies()
        }
    }
}