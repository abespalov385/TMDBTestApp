package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.model.Actor

interface ActorCacheDataSource {

    suspend fun getActorsFromCache(): List<Actor>
    suspend fun saveActorsToCache(actors: List<Actor>)
}