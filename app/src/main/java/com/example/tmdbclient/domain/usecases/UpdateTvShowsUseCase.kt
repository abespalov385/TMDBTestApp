package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository
import javax.inject.Inject

class UpdateTvShowsUseCase @Inject constructor (private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}