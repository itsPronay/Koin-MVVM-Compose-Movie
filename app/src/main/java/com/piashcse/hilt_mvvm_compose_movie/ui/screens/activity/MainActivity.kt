package com.piashcse.hilt_mvvm_compose_movie.ui.screens.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.piashcse.hilt_mvvm_compose_movie.di.KoinModules
import com.piashcse.hilt_mvvm_compose_movie.ui.screens.mainscreen.MainScreen
import com.piashcse.hilt_mvvm_compose_movie.ui.theme.KoinMVVMComposeMovieTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private val splashViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition { splashViewModel.isLoading.value }
        }

        startKoin {
            androidContext(this@MainActivity)
            modules(KoinModules.allModules)
        }

        setContent {
            KoinMVVMComposeMovieTheme {
                MainScreen()
            }
        }
    }
}