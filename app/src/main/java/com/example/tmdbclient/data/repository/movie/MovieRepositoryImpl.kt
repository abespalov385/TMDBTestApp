package com.example.tmdbclient.data.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.data.model.MovieList
import com.example.tmdbclient.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun getMovies(): Flow<List<Movie>> = flow {
        emit(movieLocalDataSource.getMoviesFromDB())
        updateMovies()
        emitAll(movieLocalDataSource.getMoviesFlowFromDB())
    }.flowOn(Dispatchers.IO)

    override suspend fun updateMovies() {
        val newListOfMovies = getMoviesFromAPI()
        if (!newListOfMovies.isNullOrEmpty()) {
            movieLocalDataSource.clearAll()
            movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        }
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList: List<Movie> = emptyList()
        withContext(Dispatchers.IO) {

            try {
                val response: Response<MovieList> = movieRemoteDataSource.getMovies()
                response.body()?.let {
                    movieList = it.movies
                }
            } catch (exception: Exception) {
                Log.i("MyTag", exception.message.toString())

            }
        }

        return movieList
    }
}