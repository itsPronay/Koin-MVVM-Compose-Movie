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

//@Module
//@InstallIn(SingletonComponent::class)
//object DataBaseModules {
//    @Provides
//    @Singleton
//    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
//        return Room.databaseBuilder(
//            context,
//            MovieDatabase::class.java,
//            "movieWorld.db"
//        ).build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideMovieDetailDao(moviesDatabase: MovieDatabase): FavoriteMovieDao =
//        moviesDatabase.getFavoriteMovieDetailDao()
//
//    @Singleton
//    @Provides
//    fun provideLocalMovieRepo(movieDao: FavoriteMovieDao): LocalMovieRepositoryImpl =
//        LocalMovieRepositoryImpl(movieDao)
//
//    @Singleton
//    @Provides
//    fun provideTvSeriesDao(moviesDatabase: MovieDatabase): FavoriteTvSeriesDao =
//        moviesDatabase.getFavoriteTvSeriesDao()
//
//    @Singleton
//    @Provides
//    fun provideLocalTvSeriesRepo(tvSeriesDao: FavoriteTvSeriesDao): LocalTvSeriesRepositoryImpl =
//        LocalTvSeriesRepositoryImpl(tvSeriesDao)
//}