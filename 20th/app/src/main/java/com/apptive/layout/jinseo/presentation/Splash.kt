package com.apptive.layout.jinseo.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apptive.layout.ui.theme.LayoutTheme
import kotlinx.coroutines.delay


enum class HomeState(val alpha: Float) {
    INVISIBLE(0f),   // INVISIBLE은 alpha 값이 0f로, 아이콘이 완전히 투명(보이지 않음)을 의미합니다.
    VISIBLE(1f)    // VISIBLE은 alpha 값이 1f로, 아이콘이 완전히 불투명(보임)을 의미합니다.
}



//IconsArea == HomeIcons
@Composable
fun SplashesScreen(navController: NavController) {
    var homeState by remember { mutableStateOf(HomeState.INVISIBLE) } // Home 아이콘의 상태를 제어하는 변수
    val homeAlpha by animateFloatAsState(
        targetValue = homeState.alpha,
        animationSpec = tween(4000), // 애니메이션 지속 시간 1500ms
        label = "IconAlpha" // 디버깅 라벨
    )

    LaunchedEffect(Unit) {
        homeState = HomeState.VISIBLE
        delay(5000)// 애니메이션 지속 시간 동안 기다리기
        navController.navigate("login")
    } // 화면을 처음 실행했을때 동작하게 만드는거

    SplashBackground {
        HomeIcons(alpha = homeAlpha)
    }


}


@Composable
private fun SplashBackground(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center,
        content = content
    )
}    //화면 색 바꾸기

@Composable
private fun HomeIcons(

    alpha: Float,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                modifier = Modifier
                    .size(70.dp)
                    .alpha(alpha),
                imageVector = Icons.Default.Home,
                tint = Color.White,
                contentDescription = "Home Logo Icon",

                )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    LayoutTheme {
        SplashesScreen(navController = rememberNavController())
    }
}
