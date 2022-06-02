package com.example.tmdbclient.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ActorsDao
import com.example.tmdbclient.data.db.MoviesDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase =
        Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb").build()


    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MoviesDao = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao = tmdbDatabase.tvDao()

    @Singleton
    @Provides
    fun provideActorDao(tmdbDatabase: TMDBDatabase): ActorsDao = tmdbDatabase.actorDao()
}