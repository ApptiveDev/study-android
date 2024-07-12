package com.apptive.state.presentation.junyoung


import android.window.SplashScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }
        var toggle by remember { mutableStateOf(0) }
        var homeVisible by remember { mutableStateOf(true) }

        val move by animateDpAsState(
            targetValue = when (toggle) {
                1 -> -50.dp
                2 -> 50.dp
                else -> 0.dp
            },
            animationSpec = tween(durationMillis = 3000)
        )

        val alpha by animateFloatAsState(
            targetValue = if (homeVisible) 1f else 0f,
            animationSpec = tween(durationMillis = 3000)
        )

        Row(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            AnimatedVisibility(visible) {
                Icon(
                    Icons.Default.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp),
                    tint = Color.White,
                )
            }
            Icon(
                Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .alpha(alpha)
                    .clickable {
                        visible = !visible
                    }
                    .offset(x = move),
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Row {
                Button(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = {
                        toggle = 1
                    }
                ) {
                    Text(text = "좌측이동")
                }
                Spacer(
                    modifier = Modifier
                        .width(15.dp)
                )
                Button(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = {
                        toggle = 2
                    }
                ) {
                    Text(text = "우측이동")
                }
            }
            Row {
                Button(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = { homeVisible = false }
                ) {
                    Text(text = "사라지기")
                }
                Spacer(
                    modifier = Modifier
                        .width(15.dp)
                )
                Button(
                    modifier = Modifier
                        .width(100.dp),
                    onClick = { homeVisible = true }
                ) {
                    Text(text = "나타나기")
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    SplashScreen()
}
