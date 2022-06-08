package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.ActorList
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActorRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
) :
    ActorRemoteDataSource {

    override suspend fun getActors(): Response<ActorList> = tmdbService.getPopularActor(apiKey)
}