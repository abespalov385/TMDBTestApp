package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.Actor

@Dao
interface ActorsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveActors(actors: List<Actor>)

    @Query("DELETE FROM popular_actors")
    suspend fun deleteAllActors()

    @Query("SELECT * FROM popular_actors")
    suspend fun getActors(): List<Actor>
}