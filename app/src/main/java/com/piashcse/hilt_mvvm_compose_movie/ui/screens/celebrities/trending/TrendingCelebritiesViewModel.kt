package com.piashcse.hilt_mvvm_compose_movie.ui.screens.celebrities.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.piashcse.hilt_mvvm_compose_movie.data.model.GenreId
import com.piashcse.hilt_mvvm_compose_movie.data.repository.remote.celebrity.CelebrityRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class TrendingCelebritiesViewModel(
    val repo: CelebrityRepository
) : ViewModel(){
    val filterData = MutableStateFlow<GenreId?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val trendingCelebrities = filterData.flatMapLatest {
        repo.trendingCelebrities(1)
    }.cachedIn(viewModelScope)

}