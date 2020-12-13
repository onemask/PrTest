package com.project.pokemon.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.project.pokemon.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokemonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)
        }
    }
}