package com.example.ordernow.ui.features.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ordernow.R
import com.example.ordernow.ui.features.home.HomeViewModel

@Composable
fun ProductListScreen(
    goToProductDetail: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.list),
            style = MaterialTheme.typography.body1
        )
        Button(
            onClick = goToProductDetail,
        ) {
            Text(text = stringResource(id = R.string.to_product_detail_screen))
        }
    }
}