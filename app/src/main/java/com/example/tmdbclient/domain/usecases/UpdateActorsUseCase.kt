package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.domain.repository.ActorRepository
import javax.inject.Inject

class UpdateActorsUseCase @Inject constructor(private val actorRepository: ActorRepository) {

    suspend fun execute() {
        actorRepository.updateActors()
    }
}