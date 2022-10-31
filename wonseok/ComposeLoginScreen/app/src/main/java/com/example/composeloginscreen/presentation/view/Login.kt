package com.example.composeloginscreen.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeloginscreen.R
import com.example.composeloginscreen._constant.Colors
import com.example.composeloginscreen.presentation.component.ImageBox
import com.example.composeloginscreen.presentation.component.VerticalGradient
import com.example.composeloginscreen.presentation.utils.ScreenUtil

@Composable
fun LoginScreen() {
    LoginBackground {
        LoginContent {

        }
    }
}

// 배경이미, 공통 여백 설정
@Composable
fun LoginBackground(
    innerPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable BoxScope.() -> Unit,
) {
    ImageBox(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        id = R.drawable.login_background,
    ) {
        VerticalGradient(
            0.6f to Color.Transparent,
            0.86f to Colors.LoginPrimaryColor
        )

        content()
    }
}

//
@Composable
fun LoginContent(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        content = content,
    )
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}