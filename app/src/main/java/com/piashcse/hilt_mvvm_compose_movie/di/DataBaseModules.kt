package com.piashcse.hilt_mvvm_compose_movie.di

import android.content.Context
import androidx.room.Room
import com.piashcse.hilt_mvvm_compose_movie.data.datasource.local.MovieDatabase
import org.koin.dsl.module

val DataBaseModule = module {

    single<MovieDatabase>{
        Room.databaseBuilder(
            get<Context>(),
            MovieDatabase::class.java,
            "movieWorld.db"
        ).build()
    }

    // provide dao
    single { get<MovieDatabase>().getFavoriteTvSeriesDao() }
    single { get<MovieDatabase>().getFavoriteMovieDetailDao() }
}
