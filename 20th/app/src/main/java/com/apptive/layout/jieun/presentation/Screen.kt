package com.apptive.layout.jieun.presentation

sealed class Screen(val route: String){ // route는 현재 스크린의 주소를 의미
    object Splash : Screen("Splash")
    object Login : Screen("Login")
    object Home : Screen("Home")
}