package com.apptive.coroutine.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun TimerScreen(){
    var seconds by remember { mutableStateOf(0) }
    var isRunning by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }

    val formattedTime = String.format(
        "%02d:%02d", seconds / 60, seconds % 60
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp)
    ) {
        Text(
            text = formattedTime,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )

        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (isRunning) {
                        job?.cancel()
                    } else {
                        job = coroutineScope.launch {
                            while (isActive) {
                                delay(1000)
                                seconds += 1
                            }
                        }
                    }
                    isRunning = !isRunning
                }
            ) {
                Text(if (isRunning) "멈춤" else "시작")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    job?.cancel()
                    seconds = 0
                    isRunning = false
                }
            ) {
                Text("리셋")
            }
        }
    }
}

@Preview
@Composable
fun TimerScreenPreview() {
    TimerScreen()
}