package com.piashcse.hilt_mvvm_compose_movie.di

import com.piashcse.hilt_mvvm_compose_movie.data.repository.local.movie.LocalMovieRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.local.movie.LocalMovieRepositoryImpl
import com.piashcse.hilt_mvvm_compose_movie.data.repository.local.tvseries.LocalTvSeriesRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.local.tvseries.LocalTvSeriesRepositoryImpl
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.artist.ArtistRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.artist.ArtistRepositoryImpl
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.celebrity.CelebrityRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.celebrity.CelebrityRepositoryImpl
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.movie.MovieRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.movie.MovieRepositoryImpl
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.tvseries.TvSeriesRepository
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.tvseries.TvSeriesRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val RepositoryModule = module {
    singleOf(::MovieRepositoryImpl) bind MovieRepository::class
    singleOf(::TvSeriesRepositoryImpl) bind TvSeriesRepository::class
    singleOf(::ArtistRepositoryImpl) bind ArtistRepository::class
    singleOf(::CelebrityRepositoryImpl) bind CelebrityRepository::class
    singleOf(::LocalMovieRepositoryImpl) bind LocalMovieRepository::class
    singleOf(::LocalTvSeriesRepositoryImpl) bind LocalTvSeriesRepository::class
}
