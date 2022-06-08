package com.example.tmdbclient.domain.usecases

import com.example.tmdbclient.data.model.Actor
import com.example.tmdbclient.domain.repository.ActorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActorsUseCase @Inject constructor(private val actorRepository: ActorRepository) {

    fun execute(): Flow<List<Actor>> = actorRepository.getActors()
}