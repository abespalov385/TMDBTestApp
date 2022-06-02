package com.example.tmdbclient.presentation.di.actor

import com.example.tmdbclient.presentation.actors.ActorsActivity
import dagger.Subcomponent

@ActorScope
@Subcomponent(modules = [ActorModule::class])
interface ActorSubComponent {
    fun inject(actorsActivity: ActorsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():ActorSubComponent
    }
}