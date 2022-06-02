package com.example.tmdbclient.data.repository.tvshow

import com.example.tmdbclient.data.model.TvShow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowCacheDataSourceImpl @Inject constructor(): TvShowCacheDataSource {

    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowsList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}