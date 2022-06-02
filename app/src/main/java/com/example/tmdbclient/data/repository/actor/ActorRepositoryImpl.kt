package com.example.tmdbclient.data.repository.actor

import android.util.Log
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.data.model.ActorList
import com.example.tmdbclient.domain.repository.ActorRepository
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActorRepositoryImpl @Inject constructor(
    private val actorRemoteDataSource: ActorRemoteDataSource,
    private val actorCacheDataSource: ActorCacheDataSource,
    private val actorLocalDataSource: ActorLocalDataSource
): ActorRepository {

    override suspend fun getActors(): List<Actor>? = getActorsFromCache()

    override suspend fun updateActors(): List<Actor>? {
        val newListOfTvShows = getActorsFromAPI()
        actorLocalDataSource.clearAll()
        actorLocalDataSource.saveActorsToDB(newListOfTvShows)
        actorCacheDataSource.saveActorsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getActorsFromAPI(): List<Actor> {
        lateinit var actorsList: List<Actor>

        try {
            val response: Response<ActorList> = actorRemoteDataSource.getActors()
            response.body()?.let {
                actorsList = it.actors
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return actorsList
    }

    suspend fun getActorsFromDB(): List<Actor> {
        lateinit var actorList: List<Actor>

        try {
            actorList = actorLocalDataSource.getActorsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (actorList.isEmpty()) {
            actorList = getActorsFromAPI()
        }

        return actorList
    }

    suspend fun getActorsFromCache(): List<Actor> {
        lateinit var actorList: List<Actor>

        try {
            actorList = actorCacheDataSource.getActorsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (actorList.isEmpty()) {
            actorList = getActorsFromDB()
            actorCacheDataSource.saveActorsToCache(actorList)
        }

        return actorList
    }
}