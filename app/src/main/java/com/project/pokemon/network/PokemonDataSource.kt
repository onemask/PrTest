package com.project.pokemon.network

import com.project.pokemon.model.PokemonList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface PokemonDataSource {
    val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList
}