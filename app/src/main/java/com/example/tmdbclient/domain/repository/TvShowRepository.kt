package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {

    fun getTvShows(): Flow<List<TvShow>>
    suspend fun updateTvShows()

}