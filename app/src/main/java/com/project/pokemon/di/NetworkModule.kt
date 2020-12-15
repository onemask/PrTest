package com.project.pokemon.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.project.pokemon.network.PokemonService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideStethoInterceptor() = StethoInterceptor()

    @Provides
    @Singleton
    fun provideKotlinJsonAdapterFactory() = KotlinJsonAdapterFactory()

    @Provides
    @Singleton
    fun provideMoshi(jsonAdapterFactory: KotlinJsonAdapterFactory): Moshi =
        Moshi.Builder().add(jsonAdapterFactory).build()

    @Provides
    @Singleton
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideOkHttpclient(logger: HttpLoggingInterceptor, stethoInterceptor: StethoInterceptor) =
        OkHttpClient.Builder().apply {
            addInterceptor(logger)
                .addNetworkInterceptor(stethoInterceptor)
                .build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(converterFactory: MoshiConverterFactory, client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) =
        retrofit.create(PokemonService::class.java)


    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}