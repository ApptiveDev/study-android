package com.apptive.layout.wonseok.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apptive.layout.wonseok.presentation.HomeScreen
import com.apptive.layout.wonseok.presentation.LoginScreen
import com.apptive.layout.wonseok.presentation.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
    }
}