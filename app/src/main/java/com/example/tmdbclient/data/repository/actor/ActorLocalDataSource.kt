package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.model.Actor
import kotlinx.coroutines.flow.Flow

interface ActorLocalDataSource {

    fun getActorsFlowFromDB(): Flow<List<Actor>>
    suspend fun getActorsFromDB(): List<Actor>
    suspend fun saveActorsToDB(actors: List<Actor>)
    suspend fun clearAll()
}