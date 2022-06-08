package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tmdbclient.data.model.Movie
import com.example.tmdbclient.domain.usecases.GetMoviesUseCase
import com.example.tmdbclient.domain.usecases.UpdateMoviesUseCase
import kotlinx.coroutines.launch

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    val allMovies: LiveData<List<Movie>> = getMoviesUseCase.execute().asLiveData()

    fun updateMovies() {
        viewModelScope.launch {
            updateMoviesUseCase.execute()
        }
    }

}