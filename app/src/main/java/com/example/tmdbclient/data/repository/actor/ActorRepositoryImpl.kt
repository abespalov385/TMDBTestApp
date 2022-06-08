package com.example.tmdbclient.data.repository.actor

import android.util.Log
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.data.model.ActorList
import com.example.tmdbclient.domain.repository.ActorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActorRepositoryImpl @Inject constructor(
    private val actorRemoteDataSource: ActorRemoteDataSource,
    private val actorLocalDataSource: ActorLocalDataSource
) : ActorRepository {

    override fun getActors(): Flow<List<Actor>> = flow {
        emit(actorLocalDataSource.getActorsFromDB())
        updateActors()
        emitAll(actorLocalDataSource.getActorsFlowFromDB())
    }.flowOn(Dispatchers.IO)

    override suspend fun updateActors() {
        val newListOfActors = getActorsFromAPI()
        if (!newListOfActors.isNullOrEmpty()) {
            actorLocalDataSource.clearAll()
            actorLocalDataSource.saveActorsToDB(newListOfActors)
        }
    }

    private suspend fun getActorsFromAPI(): List<Actor> {
        var actorsList: List<Actor> = emptyList()
        withContext(Dispatchers.IO) {

            try {
                val response: Response<ActorList> = actorRemoteDataSource.getActors()
                response.body()?.let {
                    actorsList = it.actors
                }
            } catch (exception: Exception) {
                Log.i("MyTag", exception.message.toString())

            }
        }

        return actorsList
    }
}