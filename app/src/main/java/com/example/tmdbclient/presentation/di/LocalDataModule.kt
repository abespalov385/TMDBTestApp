package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.db.ActorsDao
import com.example.tmdbclient.data.db.MoviesDao
import com.example.tmdbclient.data.db.TvShowsDao
import com.example.tmdbclient.data.repository.actor.ActorLocalDataSource
import com.example.tmdbclient.data.repository.actor.ActorLocalDataSourceImpl
import com.example.tmdbclient.data.repository.movie.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(moviesDao: MoviesDao): MovieLocalDataSource = MovieLocalDataSourceImpl(moviesDao)

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao): TvShowLocalDataSource = TvShowLocalDataSourceImpl(tvShowsDao)

    @Singleton
    @Provides
    fun provideActorLocalDataSource(actorsDao: ActorsDao): ActorLocalDataSource = ActorLocalDataSourceImpl(actorsDao)

}
