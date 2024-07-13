package com.apptive.retrofit.template

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.apptive.retrofit.template.navigation.Screen
import com.apptive.retrofit.template.navigation.SetupNavGraph
import com.apptive.retrofit.ui.theme.RetrofitTheme
import kotlinx.coroutines.delay

enum class IconPosition(val offsetX: Dp) {
    LEFT((-100).dp), CENTER(0.dp), RIGHT(100.dp)
}

enum class IconState(val alpha: Float) {
    HIDDEN(0f), NORMAL(1f)
}

@Composable
fun SplashScreen(navController: NavHostController) {
    var showCheckIcon by remember { mutableStateOf(false) }
    var iconState by remember { mutableStateOf(IconState.HIDDEN) }
    var iconPosition by remember { mutableStateOf(IconPosition.CENTER) }
    val iconOffset by animateDpAsState(
        targetValue = iconPosition.offsetX,
        animationSpec = tween(1000),
        label = "IconOffset"
    )
    val iconAlpha by animateFloatAsState(
        targetValue = iconState.alpha,
        animationSpec = tween(4000),
        label = "IconAlpha"
    )

    LaunchedEffect(key1 = true) {
        iconState = IconState.NORMAL
        delay(4000)
        navController.navigate(Screen.Login.route)
    }


    SplashBackground {
        IconsArea(
            showIcon = showCheckIcon,
            offsetX = iconOffset,
            alpha = iconAlpha,
            onClicked = { showCheckIcon = !showCheckIcon }
        )

//        ButtonsArea(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            onLeftMove = {
//                iconPosition =
//                    if (iconPosition == IconPosition.LEFT) IconPosition.CENTER
//                    else IconPosition.LEFT
//            },
//            onRightMove = {
//                iconPosition =
//                    if (iconPosition == IconPosition.RIGHT) IconPosition.CENTER
//                    else IconPosition.RIGHT
//            },
//            onAppear = { iconState = IconState.NORMAL },
//            onDisappear = { iconState = IconState.HIDDEN }
//        )
    }
}

@Composable
private fun SplashBackground(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(10.dp),
        contentAlignment = Alignment.Center,
        content = content
    )
}

@Composable
private fun IconsArea(
    showIcon: Boolean,   // true일 때 또다른 아이콘이 나타난다.
    offsetX: Dp,         // Home 아이콘의 x 위치 오프셋
    alpha : Float,       // Home 아이콘의 투명도
    onClicked: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AnimatedVisibility(visible = showIcon) {
            Icon(
                modifier = Modifier.size(60.dp),
                imageVector = Icons.Default.CheckCircle,
                tint = Color.White,
                contentDescription = "Hidden Icon"
            )
        }
        Icon(
            modifier = Modifier
                .size(100.dp)
                .offset(offsetX, 0.dp)
                .alpha(alpha)
                .clickable { onClicked() },
            imageVector = Icons.Default.Home,
            tint = Color.White,
            contentDescription = "Home Logo Icon"
        )
    }
}

@Composable
private fun ButtonsArea(
    modifier: Modifier,
    onLeftMove: () -> Unit = {},
    onRightMove: () -> Unit = {},
    onAppear: () -> Unit = {},
    onDisappear: () -> Unit = {},
) {
    Column(modifier = modifier) {
        Row {
            Button(
                modifier = Modifier.width(100.dp),
                onClick = onLeftMove
            ) {
                Text(text = "좌측이동")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                modifier = Modifier.width(100.dp),
                onClick = onRightMove
            ) {
                Text(text = "우측이동")
            }
        }

        Row {
            Button(
                modifier = Modifier.width(100.dp),
                onClick = onAppear
            ) {
                Text(text = "나타나기")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                modifier = Modifier.width(100.dp),
                onClick = onDisappear
            ) {
                Text(text = "사라지기")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    RetrofitTheme {
        val navController = rememberNavController()
        SetupNavGraph(
            navController = navController,
            startDestination = Screen.Splash
        )
    }
}