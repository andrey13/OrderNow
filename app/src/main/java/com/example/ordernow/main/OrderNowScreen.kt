package com.example.ordernow.main

import android.content.res.Resources
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.ordernow.ui.patterns.OrderNowBottomBar
import com.example.ordernow.ui.patterns.OrderNowTopBar
import com.example.ordernow.ui.theme.OrderNowTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderNowScreen() {
    OrderNowTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val appState = rememberAppState()
            Scaffold(
                scaffoldState = appState.scaffoldState,
                topBar = { OrderNowTopBar() },
                bottomBar = { OrderNowBottomBar() }
            ) { contentPadding ->
                println(contentPadding)
            }
        }
    }
}

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return  LocalContext.current.resources
}