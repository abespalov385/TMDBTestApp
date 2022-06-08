package com.example.tmdbclient.presentation.actors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.domain.usecases.GetActorsUseCase
import com.example.tmdbclient.domain.usecases.UpdateActorsUseCase
import kotlinx.coroutines.launch

class ActorViewModel(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase
): ViewModel() {

    val allActors: LiveData<List<Actor>> = getActorsUseCase.execute().asLiveData()

    fun updateActors() {
        viewModelScope.launch {
            updateActorsUseCase.execute()
        }
    }

}