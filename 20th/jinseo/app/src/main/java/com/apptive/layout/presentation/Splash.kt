package com.apptive.layout.presentation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
fun SplashScreen(){
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()

    ) {
        var Click by remember{
            mutableStateOf(0)
        }
        var HomeVisible by remember{
            mutableStateOf(true)
        }


        val offset by animateDpAsState(
            targetValue = if(Click==1) {-100.dp}
            else if (Click == -1){100.dp}
            else 0.dp
        )
        val alpha by animateFloatAsState(
            targetValue = if(HomeVisible) 1.0f else 0f,
            animationSpec = tween (3000))

        Row (
                modifier = Modifier
                    .align(Alignment.Center),)
        {

            var visible by remember{
                mutableStateOf(true)
            }
            AnimatedVisibility(visible) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp),

                    tint = Color.White
                )
            }


            
            Icon(
                Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clickable { visible = !visible }
                    .offset(x = offset, y = 0.dp)
                    .alpha(alpha = alpha),

                tint = Color.White
            )

        }

        Column (
            modifier =Modifier
                .align(Alignment.BottomCenter),
        ){
            Row {
                Button(onClick = {
                        if(Click == 0){Click = 1}
                        else{Click = 0}
                },
                    modifier = Modifier
                        .width(120.dp)) {
                    Text("왼쪽이동")
                }
                Spacer(modifier = Modifier
                    .width(15.dp))
                Button(onClick = { if(Click == 0) {Click = -1}
                                 else{Click = 0}},
                    modifier = Modifier
                        .width(120.dp)) {
                    Text("오른쪽이동")
                }
            }
            Row{
                Button(onClick = { HomeVisible = true },
                        modifier = Modifier
                            .width(120.dp),
                ) {
                    Text("나타나기")


                }
                Spacer(modifier = Modifier
                    .width(15.dp))
                Button(onClick = { HomeVisible = false},
                        modifier = Modifier
                        .width(120.dp)) {
                    Text("사라지기")
                }
            }
        }
    }



    }







@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview(){
    SplashScreen()
}