package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.actor.ActorSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createActorSubComponent(): ActorSubComponent
}