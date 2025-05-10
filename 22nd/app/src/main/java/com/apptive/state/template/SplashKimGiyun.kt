package com.apptive.state.template

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.apptive.state.ui.theme.StateTheme

//왼쪽으로 100.dp, 오른쪽으로 100.dp 움직이도록 정의하려면 어떻게 해야할까요?
enum class IconPosition(val offsetX: Dp) {
    LEFT((-100).dp), CENTER(0.dp), RIGHT(100.dp)
}

//Modifier.alpha() 속성을 확인해볼까요?
enum class IconState(val alpha: Float) {
    HIDDEN(0f), NORMAL(1f)
}

/**
 * State 학습을 위한 Splash.kt의 Screen 코드입니다.
 * @author 김기윤
 */
@Composable
fun SplashScreen() {
    var iconState by remember { mutableStateOf(IconState.NORMAL) } // 왜 remember를 사용할까요?
    var iconPosition by remember { mutableStateOf(IconPosition.CENTER) } // 기본값을 적용해두려면 어떻게 해야할까요?

    //좌, 또는 우로 이동하는 애니메이션이 1초 동안 동작하게 합시다.
    val offsetIcon by animateDpAsState(
        targetValue = iconPosition.offsetX,
        animationSpec = tween(1000),
        label = "x축으로 움직이는 아이콘에 적용되는 애니메이션입니다."
    )

    //나타나거나, 사라지는 애니메이션이 1.5초 동안 동작하게 합시다.
    val iconAlpha by animateFloatAsState(
        targetValue = iconState.alpha,
        animationSpec = tween(1500),
        label = "1.5초 간 나타나거나, 사라지는 애니메이션입니다."
    )

    SplashBackground {
        IconsArea(
            offsetX = offsetIcon, // 각 파라미터에 어떤 값을 주어야할까요?
            alpha = iconAlpha,
        )

        /*아이콘의 현 위치에 따라 동작하는 코드를 작성해봅시다.*/
        ButtonsArea(
            modifier = Modifier.align(Alignment.BottomCenter), //화면 아래의 가운데에 정렬해볼까요?
            onLeftMove = { // 좌측이동의 경우
                iconPosition =
                    if (iconPosition == IconPosition.LEFT) IconPosition.CENTER
                    else IconPosition.LEFT
            },
            onRightMove = { // 우측이동의 경우
                iconPosition =
                    if (iconPosition == IconPosition.RIGHT) IconPosition.CENTER
                    else IconPosition.RIGHT
            },
            onAppear = { iconState = IconState.NORMAL },
            onDisappear = { iconState = IconState.HIDDEN }
        )
    }
}

/**
 * SplashScreen의 배경화면입니다.
 * @author 김기윤
 */
@Composable
private fun SplashBackground(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize() //화면 크기를 최대한도로 키워봅시다.
            .background(Color.Black) //검은색으로 채워봅시다.
            .padding(10.dp),
        contentAlignment = Alignment.Center,
        content = content
    )
}

/**
 * 집 아이콘이 배치된 Composable입니다.
 * @param offsetX 오른쪽으로 이동하는 기능이 구현된 파라미터
 * @param alpha 투명도를 조절하는 기능이 구현된 파라미터
 * @author 김기윤
 */
@Composable
private fun IconsArea(
    offsetX: Dp,         // Home 아이콘의 x 위치 오프셋
    alpha : Float,       // Home 아이콘의 투명도
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .size(100.dp)
                .offset(offsetX, 0.dp) // 오프셋을 설정해봅시다. Hint! 아이콘은 X축으로 움직여요.
                .alpha(alpha), // 알파값을 조정해봅시다. (0f -> 1f)
            imageVector = Icons.Default.Home,
            tint = Color.White, //흰색으로 채워봅시다.
            contentDescription = "집 아이콘"
        )
    }
}

/**
 * 버튼 아이콘이 배치된 Composable입니다.
 * @param modifier 호이스팅 된 modifier입니다.
 * @param onLeftMove 왼쪽으로 이동하는 기능이 구현된 파라미터
 * @param onRightMove 오른쪽으로 이동하는 기능이 구현된 파라미터
 * @param onAppear 가시성 기능이 구현된 파라미터
 * @param onDisappear 비가시성 기능이 구현된 파라미터
 * @author 김기윤
 */
@Composable
private fun ButtonsArea(
    modifier: Modifier,
    onLeftMove: () -> Unit = {}, // 파라미터를 잘 활용해볼까요?
    onRightMove: () -> Unit = {},
    onAppear: () -> Unit = {},
    onDisappear: () -> Unit = {},
) {
    Column(modifier = modifier) {
        Row {
            Button(
                onClick = onLeftMove
            ) {
                Text(text = "왼쪽이동")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = onRightMove
            ) {
                Text(text = "오른쪽이동")
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
        Spacer(Modifier.height(30.dp))
    }
}

/**
 * Preview Composable입니다.
 * @author 김기윤
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    StateTheme {
        SplashScreen()  //Preview를 보려면 어떤 Composable을 등록해야할까요?
    }
}