package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(private val tvShowRepository: TvShowRepository) {

    fun execute(): Flow<List<TvShow>> = tvShowRepository.getTvShows()
}