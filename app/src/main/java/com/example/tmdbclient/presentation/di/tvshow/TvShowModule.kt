package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import com.example.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory = TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
}