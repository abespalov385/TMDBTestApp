package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tmdbclient.data.model.TvShow
import com.example.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import kotlinx.coroutines.launch

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    val allTvShows: LiveData<List<TvShow>> = getTvShowsUseCase.execute().asLiveData()

    fun updateTvShows() {
        viewModelScope.launch {
            updateTvShowsUseCase.execute()
        }
    }
}