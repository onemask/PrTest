package com.project.pokemon.di

import com.project.pokemon.network.PokemonDataSource
import com.project.pokemon.network.PokemonDataSourceImpl
import com.project.pokemon.network.PokemonRepository
import com.project.pokemon.network.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePokemonDataSource(service: PokemonService): PokemonDataSource =
        PokemonDataSourceImpl(service)

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource : PokemonDataSource): PokemonRepository =
        PokemonRepository(remoteDataSource)
}
