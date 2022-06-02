package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.model.Actor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActorCacheDataSourceImpl @Inject constructor(): ActorCacheDataSource {

    private var actorsList = ArrayList<Actor>()
    override suspend fun getActorsFromCache(): List<Actor> = actorsList

    override suspend fun saveActorsToCache(actors: List<Actor>) {
        actorsList.clear()
        actorsList = ArrayList(actors)
    }
}