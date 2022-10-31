package com.example.composeloginscreen.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun VerticalGradient(
    vararg colorStops: Pair<Float, Color>
) {
    val gradient = Brush.verticalGradient(*colorStops)
    
    Box(modifier = Modifier.fillMaxSize().background(gradient))
}