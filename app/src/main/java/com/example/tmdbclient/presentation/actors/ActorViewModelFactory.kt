package com.example.tmdbclient.presentation.actors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecases.GetActorsUseCase
import com.example.tmdbclient.domain.usecases.UpdateActorsUseCase

class ActorViewModelFactory(
    private val getActorsUseCase: GetActorsUseCase,
    private val updateActorsUseCase: UpdateActorsUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = ActorViewModel(getActorsUseCase, updateActorsUseCase) as T
}