package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.ActorList
import com.example.tmdbclient.data.model.MovieList
import com.example.tmdbclient.data.model.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("/3/tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("/3/person/popular")
    suspend fun getPopularActor(@Query("api_key") apiKey: String): Response<ActorList>
}