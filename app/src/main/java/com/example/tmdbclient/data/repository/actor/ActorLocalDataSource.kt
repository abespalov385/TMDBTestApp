package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.model.Actor

interface ActorLocalDataSource {

    suspend fun getActorsFromDB(): List<Actor>
    suspend fun saveActorsToDB(actors: List<Actor>)
    suspend fun clearAll()
}