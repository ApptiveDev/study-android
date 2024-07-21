package com.apptive.layout.wonseok.presentation

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.apptive.layout.R
import com.apptive.layout.wonseok.presentation.navigation.Screen

@Composable
fun LoginScreen(navController: NavHostController) {
    backgroundBox {
        loginColumn {
            logoImage()
            inputForm(
                "Username",
                Icons.Default.Person
            )
            Spacer(Modifier.size(10.dp))
            inputForm(
                "Password",
                Icons.Default.Lock
            )
            Spacer(Modifier.size(10.dp))
            signInButton(
                onClick = { navController.navigate(Screen.Home.route) }
            )
        }
    }
}

@Composable
fun backgroundBox(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_image),
                contentScale = ContentScale.FillBounds
            ),
        contentAlignment = Alignment.Center,
        content = content
    )
}

@Composable
fun loginColumn(content: @Composable ColumnScope.() -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
fun logoImage() {
    Image(
        imageVector =  Icons.Default.FavoriteBorder,
        contentDescription = "logoImage",
        modifier = Modifier
            .padding(10.dp)
            .size(70.dp)
    )
}

@Composable
fun signInButton(
    onClick: () -> Unit
) {
    Button(
        onClick = {onClick()},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("SIGN IN")
    }
}

@Composable
fun inputForm(
    label:String,
    iconImage: ImageVector
) {
    var text by remember { mutableStateOf(label) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            )

    ){
        Image(
            imageVector =  iconImage,
            contentDescription = "iconImage",
            modifier = Modifier
                .padding(start = 10.dp)
        )
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 15.dp, start = 10.dp, end = 15.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginPreview() {
    LoginScreen(rememberNavController())
}