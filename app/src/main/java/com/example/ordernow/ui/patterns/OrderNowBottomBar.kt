package com.example.ordernow.ui.patterns


import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ordernow.common.navigation.NavigationBarSection

@Composable
fun OrderNowBottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background),
        elevation = 10.dp
    ) {
        NavigationBarSection.sections.forEach { section ->
            val selected =
                currentDestination?.hierarchy?.any {
                    it.route == section.route
                } == true
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = stringResource(section.title)
                    )
                },
                label = { Text(text = stringResource(section.title)) },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.Red,
                onClick = {
                    navController.navigate(section.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}