package com.piashcse.hilt_mvvm_compose_movie.ui.screens.celebrities.popular

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.piashcse.hilt_mvvm_compose_movie.ui.component.Celebrities
import org.koin.androidx.compose.koinViewModel

@Composable
fun PopularCelebrities(
    navController: NavController,
    viewModel: PopularCelebritiesViewModel = koinViewModel()
) {
    Celebrities(
        navController = navController,
        celebrities = viewModel.popularCelebrities.collectAsLazyPagingItems()
    )
}