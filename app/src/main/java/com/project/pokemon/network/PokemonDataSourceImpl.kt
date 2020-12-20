package com.project.pokemon.network

import com.project.pokemon.model.PokemonList
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonDataSourceImpl @Inject constructor(val pokemonService: PokemonService) :
    PokemonDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): PokemonList =
        withContext(ioDispatcher) {
            pokemonService.getPokemonList(limit, offset)
        }

}