package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.model.ActorList
import retrofit2.Response

interface ActorRemoteDataSource {

    suspend fun getActors(): Response<ActorList>
}