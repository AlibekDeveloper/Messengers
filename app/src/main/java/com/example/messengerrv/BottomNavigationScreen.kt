package com.example.messengerrv

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()

    val navItems = listOf(
        BottomNavigationItemData(
            "screen1",
            R.drawable.ic_createorders,
            stringResource(id = R.string.create_orders)
        ),
        BottomNavigationItemData(
            "screen2",
            R.drawable.ic_myorders,
            stringResource(id = R.string.my_orders)
        ),
        BottomNavigationItemData(
            "screen3",
            R.drawable.ic_basket,
            stringResource(id = R.string.basket)
        ),
        BottomNavigationItemData(
            "screen4",
            R.drawable.ic_profile,
            stringResource(id = R.string.profile)
        )
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                navItems.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.route,
                        onClick = { navController.navigate(item.route) },
                        icon = {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.label,
                                modifier = Modifier.size(24.dp),
                                tint = if (currentRoute == item.route) Color(0xFF49A2E1) else LocalContentColor.current

                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small)),
                                maxLines = 1,
                                color = if (currentRoute == item.route) Color(0xFF49A2E1) else LocalContentColor.current,
                                style = TextStyle(fontSize = 8.sp),
                                softWrap = false
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = "screen1") {
            composable("screen1") { }
            composable("screen2") { }
            composable("screen3") { }
            composable("screen4") { }
        }
    }
}

data class BottomNavigationItemData(
    val route: String,
    val icon: Int,
    val label: String
)
