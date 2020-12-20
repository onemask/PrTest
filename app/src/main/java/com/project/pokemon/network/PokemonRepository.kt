package com.project.pokemon.network

import com.project.pokemon.model.PokemonList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val remoteDataSource: PokemonDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getPokemonList(limit: Int, offset: Int): PokemonList =
        withContext(ioDispatcher) {
            remoteDataSource.getPokemonList(limit, offset)
        }

}