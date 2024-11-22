package com.example.a21st.template

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a21st.ui.theme._21stTheme

@Composable
fun SplashScreen() {
    // 다음의 변수를 활용하여 애니메이션을 줄 수 있습니다.
    var isIconClicked by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isIconClicked) 0f else 1f, label = ""
    )

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