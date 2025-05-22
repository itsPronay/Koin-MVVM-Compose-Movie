package com.piashcse.hilt_mvvm_compose_movie.di

import org.koin.dsl.module

object KoinModules {
    val allModules = module {
        includes(
            DataBaseModule,
            FeatureModules,
            NetworkModule,
            RepositoryModule
        )
    }
}