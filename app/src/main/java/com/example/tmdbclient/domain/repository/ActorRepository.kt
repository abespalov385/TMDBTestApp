package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.Actor
import kotlinx.coroutines.flow.Flow

interface ActorRepository {

    fun getActors(): Flow<List<Actor>>
    suspend fun updateActors()
}