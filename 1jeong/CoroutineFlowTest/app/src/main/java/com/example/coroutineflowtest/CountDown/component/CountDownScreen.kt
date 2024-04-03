package com.example.coroutineflowtest.CountDown.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow

@Composable
fun CountDownScreen(flow: Flow<Int>) {
    val countDownNumber by flow.collectAsState(initial = 10)
    when (countDownNumber){
        in 1..10 -> {
            CustomText(text = "Countdown: $countDownNumber")
        }
        else -> {
            CustomText(text = "Merry Christmas", Color.Red)
        }
    }
}