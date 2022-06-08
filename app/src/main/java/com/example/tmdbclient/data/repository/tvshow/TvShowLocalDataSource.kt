package com.example.tmdbclient.data.repository.tvshow

import com.example.tmdbclient.data.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowLocalDataSource {

    fun getTvShowsFlowFromDB(): Flow<List<TvShow>>
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}