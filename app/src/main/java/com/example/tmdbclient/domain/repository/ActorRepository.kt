package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.Actor

interface ActorRepository {

    suspend fun getActors(): List<Actor>?
    suspend fun updateActors(): List<Actor>?
}