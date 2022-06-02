package com.example.tmdbclient.presentation.actors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecases.GetActorsUseCase
import com.example.tmdbclient.domain.usecases.UpdateActorsUseCase

class ActorViewModel(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase
): ViewModel() {

    fun getActors() = liveData {
        val actorsList = getActorsUseCase.execute()
        emit(actorsList)
    }

    fun updateActors() = liveData {
        val actorsList = updateActorsUseCase.execute()
        emit(actorsList)
    }

}