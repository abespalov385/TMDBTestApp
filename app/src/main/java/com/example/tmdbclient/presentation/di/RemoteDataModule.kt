package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.actor.ActorRemoteDataSource
import com.example.tmdbclient.data.repository.actor.ActorRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource =
        TvShowRemoteDataSourceImpl(tmdbService, apiKey)

    @Singleton
    @Provides
    fun provideActorRemoteDataSource(tmdbService: TMDBService): ActorRemoteDataSource =
        ActorRemoteDataSourceImpl(tmdbService, apiKey)
}