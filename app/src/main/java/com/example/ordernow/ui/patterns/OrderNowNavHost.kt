package com.example.ordernow.ui.patterns

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ordernow.common.navigation.NavigationBarSection
import com.example.ordernow.common.navigation.OrderNowScreenRoute
import com.example.ordernow.common.navigation.navigateSaved
import com.example.ordernow.common.navigation.popUp
import com.example.ordernow.main.OrderNowState
import com.example.ordernow.ui.features.cart.CartScreen
import com.example.ordernow.ui.features.home.HomeScreen
import com.example.ordernow.ui.features.productdetail.ProductDetailScreen
import com.example.ordernow.ui.features.productlist.ProductListScreen

@Composable
fun OrderNowNavHost(
    appState: OrderNowState,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = appState.navController,
        startDestination = NavigationBarSection.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        appSoGraph(appState)
    }
}

fun NavGraphBuilder.appSoGraph(appState: OrderNowState) {

    val homeRoute = OrderNowScreenRoute.Home.route
    val listRoute = OrderNowScreenRoute.ProductList.route
    val detailRoute = OrderNowScreenRoute.ProductDetail.route

    val goToListFromHome: () -> Unit = {
        appState.navigateSaved(listRoute, homeRoute)
    }

    val goToDetailFromList: () -> Unit = {
        appState.navigateSaved(detailRoute, listRoute)
    }

    val goBack: () -> Unit = {
        appState.popUp()
    }

    composable(NavigationBarSection.Home.route) {
        HomeScreen(goToProductList = goToListFromHome)
    }

    composable(NavigationBarSection.Cart.route) {
        CartScreen()
    }

    composable(OrderNowScreenRoute.ProductList.route) {
        ProductListScreen(goToProductDetail = goToDetailFromList)
    }

    composable(OrderNowScreenRoute.ProductDetail.route) {
        ProductDetailScreen(goToBack = goBack)
    }
}