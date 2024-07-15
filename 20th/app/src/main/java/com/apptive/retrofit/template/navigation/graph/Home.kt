package com.apptive.retrofit.template.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apptive.retrofit.template.HomeScreen
import com.apptive.retrofit.template.navigation.Screen

@Composable
fun SetupHomeNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}