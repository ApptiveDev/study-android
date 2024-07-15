package com.apptive.retrofit.template.navigation

sealed class RootScreen(
    val route: String
) {
    data object Splash: RootScreen(route = "screen-splash")
    data object Login: RootScreen(route = "screen-login")
    data object Home: RootScreen(route = "screen-home")
}