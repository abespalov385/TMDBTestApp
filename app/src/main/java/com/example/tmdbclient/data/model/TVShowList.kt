package com.example.tmdbclient.data.model


import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val results: List<TvShow>,
)