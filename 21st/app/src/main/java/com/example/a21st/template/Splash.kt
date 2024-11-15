package com.example.a21st.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a21st.ui.theme._21stTheme

@Composable
fun SplashScreen() {
    SplashBackground {

    }
}

@Composable
private fun SplashBackground(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier,
        content = content
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    _21stTheme {
        SplashScreen()
    }
}