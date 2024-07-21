package com.apptive.coroutine.template

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apptive.coroutine.ui.theme.CoroutineTheme

@Composable
fun TimerScreen() {
    TimerBackground {

    }
}

@Composable
private fun TimerBackground(
    content: @Composable BoxScope.() -> Unit
) {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewTimerScreen() {
    CoroutineTheme {
        TimerScreen()
    }
}