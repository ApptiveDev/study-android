package com.apptive.retrofit.template

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}