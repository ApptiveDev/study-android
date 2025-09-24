package com.apptive.project23.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apptive.project23.ui.home.HomeScreen
import com.apptive.project23.ui.member.*

object Routes {
    const val Home = "home"
    const val Member1 = "member1"
    const val Member2 = "member2"
    const val Member3 = "member3"
    const val Member4 = "member4"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Home) {
        composable(Routes.Home) {
            HomeScreen(
                onOpen = { route -> navController.navigate(route) }
            )
        }
        composable(Routes.Member1) {
            Member1Screen(onBack = { navController.navigateUp() })
        }
        composable(Routes.Member2) {
            Member2Screen(onBack = { navController.navigateUp() })
        }
        composable(Routes.Member3) {
            Member3Screen(onBack = { navController.navigateUp() })
        }
        composable(Routes.Member4) {
            Member4Screen(onBack = { navController.navigateUp() })
        }
    }
}
