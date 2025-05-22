package com.piashcse.hilt_mvvm_compose_movie.ui.screens.tvseries.popular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.piashcse.hilt_mvvm_compose_movie.data.model.moviedetail.Genre
import com.piashcse.hilt_mvvm_compose_movie.navigation.Screen
import com.piashcse.hilt_mvvm_compose_movie.ui.component.TvSeries
import component.base.BaseColumn
import org.koin.androidx.compose.koinViewModel

@Composable
fun PopularTvSeries(
    navController: NavController,
    genres: List<Genre>? = null,
    viewModel: PopularTvSeriesViewModel = koinViewModel()
) {
    val tvSeriesItems = viewModel.popularTvSeries.collectAsLazyPagingItems()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(tvSeriesItems.loadState) {
        viewModel.updateLoadState(tvSeriesItems.loadState)
    }

    BaseColumn(
        loading = uiState.isLoading,
        errorMessage = uiState.errorMessage
    ) {
        TvSeries(
            tvSeries = tvSeriesItems,
            genres = genres,
            selectedName = viewModel.selectedGenre.value,
            onclickGenre = viewModel::onGenreSelected,
            onclick = {
                navController.navigate(Screen.TvSeriesDetail.route.plus("/${it.id}"))
            }
        )
    }
}