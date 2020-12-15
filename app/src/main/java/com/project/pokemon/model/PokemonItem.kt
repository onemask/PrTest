package com.project.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonItem(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)