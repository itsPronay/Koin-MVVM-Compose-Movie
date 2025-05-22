package com.piashcse.hilt_mvvm_compose_movie.ui.screens.celebrities.trending

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.piashcse.hilt_mvvm_compose_movie.ui.component.Celebrities
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun TrendingCelebrities(
    navController: NavController,
    viewModel: TrendingCelebritiesViewModel = koinViewModel()
) {
    Celebrities(
        navController = navController,
        celebrities = viewModel.trendingCelebrities.collectAsLazyPagingItems()
    )
}