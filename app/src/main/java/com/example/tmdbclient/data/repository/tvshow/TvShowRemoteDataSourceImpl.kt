package com.example.tmdbclient.data.repository.tvshow

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.ActorList
import com.example.tmdbclient.data.model.TVShowList
import com.example.tmdbclient.data.model.TvShow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRemoteDataSourceImpl @Inject constructor(private val tmdbService: TMDBService, private val apiKey: String):
    TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)
}