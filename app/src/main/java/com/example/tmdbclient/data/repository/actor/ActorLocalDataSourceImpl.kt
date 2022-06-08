package com.example.tmdbclient.data.repository.actor

import com.example.tmdbclient.data.db.ActorsDao
import com.example.tmdbclient.data.model.Actor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActorLocalDataSourceImpl @Inject constructor(private val actorsDao: ActorsDao) :
    ActorLocalDataSource {

    override fun getActorsFlowFromDB(): Flow<List<Actor>> = actorsDao.getActorsFlow()

    override suspend fun getActorsFromDB(): List<Actor> = actorsDao.getActors()

    override suspend fun saveActorsToDB(actors: List<Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            actorsDao.saveActors(actors)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            actorsDao.deleteAllActors()
        }
    }
}