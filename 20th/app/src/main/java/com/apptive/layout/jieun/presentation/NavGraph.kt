package com.apptive.layout.jieun.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavGraph {
    @Composable
    fun SetupNavGraph(
        navController: NavHostController,
        startScreen: Screen.Splash
    ) {
        NavHost (
            navController = navController,
            startDestination = startScreen.route
        ){
            composable(Screen.Splash.route) {
                SplashScreen(navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Home.route) {
                HomeScreen()
            }
        }
    }
}