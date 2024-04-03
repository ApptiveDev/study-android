package com.android.loginexample.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.loginexample.R
import com.android.loginexample.ui.theme.DarkBlueButton
import com.android.loginexample.ui.theme.Typography
import com.android.loginexample.ui.theme.backgroundPink
import com.android.loginexample.ui.theme.blueButton

@Composable
fun LoginScreen(){
    ImageWithBackground(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = "login_background"
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            LoginMessage(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 200.dp))
            GetUserInfo(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp))
            LoginButton()
            DivideOr(Modifier.padding(20.dp).fillMaxWidth())
            SocialLoginButton()
            Spacer(modifier = Modifier.height(10.dp))
            SocialLoginButton(
                text = "Sign in with Google",
                resId = R.drawable.google_logo
            )
        }
    }
}
@Composable
fun SocialLoginButton(
    text: String = "Sign in with Facebook",
    @DrawableRes resId: Int = R.drawable.facebook_logo,
    onClick: () -> Unit = {}
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(DarkBlueButton),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.size(250.dp, 50.dp)
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(20.dp)
                    .align(Alignment.CenterStart),
                tint = White,
                painter = painterResource(id = resId),
                contentDescription = "social login image"
            )
            Text(
                text = text,
                color = White,
                style = Typography.body2,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
@Composable
fun DivideOr(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(Modifier.weight(1f), color = White)
        Text(
            text = "OR",
            style = Typography.body1,
            color = White,
            modifier = Modifier.padding(horizontal = 10.dp),
        )
        Divider(Modifier.weight(1f), color = White)
    }
}
@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(blueButton),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .width(120.dp)
            .height(40.dp)
    ){
        Text(
            text = "LOGIN",
            style = Typography.body1,
            color = White
        )
    }
}
@Composable
fun GetUserInfo(
    modifier: Modifier = Modifier
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailFocus by remember {mutableStateOf(false)}
    var passwordFocus by remember {mutableStateOf(false)}

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {/*
        Text(
            text = "Email Address",
            style = Typography.body2,
            color = White
        )
        Divider(modifier = Modifier
            .height(1.dp)
            .width(250.dp), color = White)
        Text(
            text = "Password",
            style = Typography.body2,
            color = White
        )
        Divider(modifier = Modifier
            .height(1.dp)
            .width(230.dp), color = White)*/
        Box {
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.onFocusChanged { emailFocus = !emailFocus },
                textStyle = Typography.body2,
                singleLine = true
            )
            if (emailFocus && email.isBlank()){
                Text(text = "Email Address", style = Typography.body2, color = White)
            }
        }
        Divider(modifier = Modifier
            .height(1.dp)
            .width(250.dp), color = White)
        Box {
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.onFocusChanged { passwordFocus = !passwordFocus },
                textStyle = Typography.body2,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )
            if (passwordFocus && password.isBlank()){
                Text(text = "Password", style = Typography.body2, color = White, textAlign = TextAlign.Center)
            }
        }
        Divider(modifier = Modifier
            .height(1.dp)
            .width(230.dp), color = White)
    }
}
@Composable
fun LoginMessage(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            style = Typography.h5,
            color = White
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Please Login to your acoount.",
            style = Typography.body1,
            color = White
        )
    }
}

@Composable
fun ImageWithBackground(
    painter: Painter,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    content: @Composable () -> Unit = {}
) {
    Box {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            alignment = Alignment.Center,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            modifier = Modifier
                .matchParentSize()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, backgroundPink),
                        startY = size.height / 3,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient)
                    }
                }
        )
        content()
    }
}