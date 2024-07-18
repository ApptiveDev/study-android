package com.apptive.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apptive.layout.jinseo.presentation.HomeScreen
import com.apptive.layout.jinseo.presentation.LoginScreen
import com.apptive.layout.jinseo.presentation.SplashesScreen
import com.apptive.layout.junyoung.presentation.SplashScreen
import com.apptive.layout.ui.theme.LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph()
                }
            }
        }
    }
}


@Composable
fun NavGraph(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash" ){
        composable("splash"){ SplashesScreen(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("home"){ HomeScreen()}
    }
}


