package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor (private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}