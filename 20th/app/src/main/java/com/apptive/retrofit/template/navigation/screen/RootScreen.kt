package com.apptive.retrofit.template.navigation.screen

sealed class Root(
    val route: String
) {
    data object Splash: Root(route = "screen-splash")
    data object Login: Root(route = "screen-login")
    data object Home: Root(route = "screen-home")
}