package com.example.ordernow.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ordernow.ui.patterns.OrderNowBottomBar
import com.example.ordernow.ui.patterns.OrderNowTopBar
import com.example.ordernow.ui.theme.OrderNowTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderNowScreen() {
    OrderNowTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = { OrderNowTopBar() },
                bottomBar = { OrderNowBottomBar() }
            ) { innerPaddingModifier ->
                println(innerPaddingModifier)
            }
        }
    }
}