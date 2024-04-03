package com.example.coroutineflowtest.CountDown

import androidx.compose.runtime.Composable
import com.example.coroutineflowtest.CountDown.component.ComposableBackground
import com.example.coroutineflowtest.CountDown.component.CountDownScreen

@Composable
fun MainScreen() {
    ComposableBackground {
        CountDownScreen(countDownFlow())
    }
}