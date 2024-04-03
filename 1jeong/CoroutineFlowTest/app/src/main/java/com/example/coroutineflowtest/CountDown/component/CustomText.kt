package com.example.coroutineflowtest.CountDown.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun CustomText(
    text: String = "",
    color: Color = Color.Black
) {
    Text(
        text  = text,
        style = TextStyle.Default,
        color = color
    )
}