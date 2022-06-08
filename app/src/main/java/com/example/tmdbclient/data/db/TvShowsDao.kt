package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.TvShow
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows(): List<TvShow>

    @Query("SELECT * FROM popular_tv_shows")
    fun getTvShowsFlow(): Flow<List<TvShow>>
}