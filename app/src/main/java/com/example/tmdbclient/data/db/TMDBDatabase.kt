package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.data.model.TvShow

@Database(entities = [Movie::class, TvShow::class, Actor::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MoviesDao
    abstract fun tvDao(): TvShowsDao
    abstract fun actorDao(): ActorsDao
}