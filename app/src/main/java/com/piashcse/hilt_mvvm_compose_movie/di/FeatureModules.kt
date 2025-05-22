package com.piashcse.hilt_mvvm_compose_movie.di

import com.piashcse.hilt_mvvm_compose_movie.ui.screens.activity.MainActivityViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.artist_detail.ArtistDetailViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.celebrities.popular.PopularCelebritiesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.celebrities.trending.TrendingCelebritiesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.favorite.movie.FavoriteMovieViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.favorite.tvseries.FavoriteTvSeriesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.mainscreen.MainViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.movies.movie_detail.MovieDetailViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.movies.nowplaying.NowPlayingMovieViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.movies.popular.PopularMovieViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.movies.toprated.TopRatedMovieViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.movies.upcoming.UpComingMovieViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.airing_today.AiringTodayTvSeriesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.on_the_air.OnTheAirTvSeriesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.popular.PopularTvSeriesViewModel
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.tv_series_detail.TvSeriesDetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Registering all the viewModels here
 */
val FeatureModules = module {
    viewModelOf(::MainActivityViewModel)
    viewModelOf(::ArtistDetailViewModel)
    viewModelOf(::PopularCelebritiesViewModel)
    viewModelOf(::TrendingCelebritiesViewModel)
    viewModelOf(::FavoriteMovieViewModel)
    viewModelOf(::FavoriteTvSeriesViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::MovieDetailViewModel)
    viewModelOf(::NowPlayingMovieViewModel)
    viewModelOf(::PopularMovieViewModel)
    viewModelOf(::TopRatedMovieViewModel)
    viewModelOf(::UpComingMovieViewModel)
    viewModelOf(::AiringTodayTvSeriesViewModel)
    viewModelOf(::OnTheAirTvSeriesViewModel)
    viewModelOf(::PopularTvSeriesViewModel)
    viewModelOf(::TopRatedMovieViewModel)
    viewModelOf(::TvSeriesDetailViewModel)
}