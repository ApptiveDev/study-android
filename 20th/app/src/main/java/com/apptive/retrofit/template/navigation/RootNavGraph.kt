package com.apptive.retrofit.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apptive.retrofit.template.HomeScreen
import com.apptive.retrofit.template.LoginScreen
import com.apptive.retrofit.template.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: RootScreen
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(route = RootScreen.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = RootScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = RootScreen.Home.route) {
            HomeScreen()
        }
    }
}