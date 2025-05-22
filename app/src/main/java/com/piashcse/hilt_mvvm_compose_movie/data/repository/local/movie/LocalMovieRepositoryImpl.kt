package com.piashcse.hilt_mvvm_compose_movie.data.repository.local.movie

import com.piashcse.hilt_mvvm_compose_movie.data.datasource.local.dao.FavoriteMovieDao
import com.piashcse.hilt_mvvm_compose_movie.data.model.moviedetail.MovieDetail

class LocalMovieRepositoryImpl (
    private val movieDao: FavoriteMovieDao,
) : LocalMovieRepository {

    override suspend fun favoriteMovies(): List<MovieDetail?> {
        return movieDao.getAllMovieDetails()
    }

    override suspend fun removeMovieById(movieId: Int) {
        movieDao.deleteMovieDetailById(movieId)
    }

}