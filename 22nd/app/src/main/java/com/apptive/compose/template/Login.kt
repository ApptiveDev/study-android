package com.apptive.compose.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Apptive 안드로이드 스터디를 위한 예시 코드로, LoginScreen을 구현했습니다.
 * @author 김기윤
 */
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
//            .paint(
//                painter = painterResource(R.drawable.background_image),
//                contentScale = ContentScale.FillBounds
//            )
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play Button",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        LoginTextField(Icons.Default.Person, placeHolder = "Username", color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField(Icons.Default.Lock, placeHolder = "Password", color = Color.White)
        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField(color = Color(0xFF3399FF))
        HorizontalDivider(
            modifier = Modifier.padding(top = 50.dp, bottom = 24.dp),
            color = Color.White
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.Normal)) {
                    append("계정이 없으신가요?  ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF3399FF), fontWeight = FontWeight.ExtraBold)) {
                    append("Login")
                }
            },
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

/**
 * Apptive 안드로이드 스터디를 위한 예시 코드로, LoginScreen에 사용되는 TextField Composable입니다.
 * @param fieldIcon(ImageVector ? null) : Textfield 좌측에 삽입될 Icon입니다.
 * @param placeHolder(String) : TextField의 PlaceHolder입니다.
 * @param color(Color) : TextField의 배경색입니다.
 * @author 김기윤
 */
@Composable
fun LoginTextField(fieldIcon: ImageVector? = null, placeHolder: String = "", color: Color) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(50.dp)
            .background(color = color)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (fieldIcon != null) {
            Icon(
                imageVector = fieldIcon,
                contentDescription = "Textfield Icon",
                tint = Color.Gray,
                modifier = Modifier
                    .fillMaxHeight()
            )
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(placeHolder) },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                textStyle = TextStyle(
                    textAlign = TextAlign.Start,
                    fontSize = 17.sp
                ),
            )
        } else {
            Text(
                text = "SIGN IN",
                color = Color.White,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginPreview() {
    LoginScreen()
}

@Preview
@Composable
fun LoginTextFieldPreview() {
    LoginTextField(Icons.Default.Person, "Username", color = Color.White)
}