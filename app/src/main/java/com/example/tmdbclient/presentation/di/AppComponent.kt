package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.actor.ActorSubComponent
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataBaseModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    LocalDataModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun actorSubComponent(): ActorSubComponent.Factory

}