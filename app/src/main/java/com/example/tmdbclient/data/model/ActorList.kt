package com.example.tmdbclient.data.model


import com.google.gson.annotations.SerializedName

data class ActorList(
    @SerializedName("results")
    val actors: List<Actor>,
)