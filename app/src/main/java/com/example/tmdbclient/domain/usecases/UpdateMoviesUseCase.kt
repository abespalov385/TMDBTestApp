package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.domain.repository.MovieRepository
import javax.inject.Inject

class UpdateMoviesUseCase @Inject constructor (private val movieRepository: MovieRepository) {

    suspend fun execute() {
        movieRepository.updateMovies()
    }
}