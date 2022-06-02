package com.example.tmdbclient.presentation.di.actor

import com.example.tmdbclient.domain.usecases.GetActorsUseCase
import com.example.tmdbclient.domain.usecases.UpdateActorsUseCase
import com.example.tmdbclient.presentation.actors.ActorViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ActorModule {

    @ActorScope
    @Provides
    fun provideActorViewModelFactory(
        getActorsUseCase: GetActorsUseCase,
        updateActorsUseCase: UpdateActorsUseCase
    ): ActorViewModelFactory = ActorViewModelFactory(getActorsUseCase, updateActorsUseCase)
}