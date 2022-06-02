package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.repository.actor.ActorCacheDataSource
import com.example.tmdbclient.data.repository.actor.ActorCacheDataSourceImpl
import com.example.tmdbclient.data.repository.movie.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.TvShowCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class CacheDataModule {

    @Singleton
    @Binds
    abstract fun bindMovieCacheDataSource(movieCacheDataSourceImpl: MovieCacheDataSourceImpl): MovieCacheDataSource

    @Singleton
    @Binds
    abstract fun bindTvShowCacheDataSource(tvShowCacheDataSourceImpl: TvShowCacheDataSourceImpl): TvShowCacheDataSource

    @Singleton
    @Binds
    abstract fun bindActorCacheDataSource(actorCacheDataSourceImpl: ActorCacheDataSourceImpl): ActorCacheDataSource

}
