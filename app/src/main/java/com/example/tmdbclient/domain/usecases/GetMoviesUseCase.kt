package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    fun execute(): Flow<List<Movie>> = movieRepository.getMovies()
}