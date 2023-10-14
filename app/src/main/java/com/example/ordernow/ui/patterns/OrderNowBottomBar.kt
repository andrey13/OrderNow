package com.example.ordernow.ui.patterns

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.ui.unit.dp

@Composable
fun OrderNowBottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        elevation = 10.dp
    ) {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, "")
            },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            unselectedContentColor = Color.Gray,
            selectedContentColor = Color.Red,
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.ShoppingCart, "")
            },
            label = { Text(text = "Cart") },
            selected = (selectedIndex.value == 1),
            unselectedContentColor = Color.Gray,
            selectedContentColor = Color.Red,
            onClick = {
                selectedIndex.value = 1
            })
    }
}