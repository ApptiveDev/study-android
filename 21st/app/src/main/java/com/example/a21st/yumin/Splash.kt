package com.example.a21st.yumin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a21st.ui.theme._21stTheme

enum class POSITION {
    LEFT, CENTER, RIGHT
}

@Composable
fun SplashScreen() {
    SplashBackground {
        var isVisible by remember { mutableStateOf(true) } // 초기 상태: 보이는 상태
        var isCheck by remember { mutableStateOf(false) } // 체크 아이콘 상태
        var position by remember { mutableStateOf(0.dp) } // 아이콘의 현재 위치 (초기값: 0.dp)

        val alpha by animateFloatAsState(
            targetValue = if (isVisible) 1f else 0f,
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 1500)
        )

        val animatedPosition by animateDpAsState(
            targetValue = position,
            animationSpec = androidx.compose.animation.core.tween(durationMillis = 1500)
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.Center)
            ) {
                AnimatedVisibility(visible = isCheck) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "check",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                    )
                }

                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "home",
                    tint = Color.White,
                    modifier = Modifier
                        .size(100.dp)
                        .alpha(alpha)
                        .clickable { isCheck = !isCheck }
                        .offset(x = animatedPosition)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
            ) {
                Button(
                    onClick = {
                        position = (position - 100.dp)
                    },
                    modifier = Modifier
                        .width(width = 115.dp)
                        .padding(1.dp)
                ) {
                    Text(text = "왼쪽이동")
                }
                Button(
                    onClick = {
                        position = (position + 100.dp)
                    },
                    modifier = Modifier
                        .width(width = 115.dp)
                        .padding(1.dp)
                ) {
                    Text(text = "오른쪽이동")
                }
            }
            Row(
                modifier = Modifier
            ) {
                Button(
                    onClick = { isVisible = true },
                    modifier = Modifier
                        .width(width = 115.dp)
                        .padding(1.dp)
                ) {
                    Text(text = "나타나기")
                }
                Button(
                    onClick = { isVisible = false },
                    modifier = Modifier
                        .width(width = 115.dp)
                        .padding(1.dp)
                ) {
                    Text(text = "사라지기")
                }
            }
        }
    }
}

@Composable
private fun SplashBackground(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
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