package com.apptive.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.apptive.layout.jieun.presentation.NavGraph
import com.apptive.layout.jieun.presentation.Screen
import com.apptive.layout.jinseo.presentation.LoginScreen
import com.apptive.layout.junyoung.presentation.SplashScreen
import com.apptive.layout.ui.theme.LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutTheme {
                val navController = rememberNavController()
                val navGraph = NavGraph()
                navGraph.SetupNavGraph(
                    navController = navController,
                    startScreen = Screen.Splash
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutTheme {
        Greeting("Android")
    }
}