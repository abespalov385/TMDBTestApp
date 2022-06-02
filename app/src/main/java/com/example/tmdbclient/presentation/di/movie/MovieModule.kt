package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecases.GetMoviesUseCase
import com.example.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory = MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
}