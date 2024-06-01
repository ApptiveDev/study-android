package com.apptive.layout.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {

}

@Composable
private fun loginLogo(icon: ImageVector) {
    Icon(
        modifier = Modifier
            .padding(20.dp)
            .size(80.dp),
        imageVector = icon,
        contentDescription = null
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun inputForm(icon: ImageVector, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(10.dp),
            imageVector = icon,
            contentDescription = null)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = label
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
private fun inputButton(text: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        onClick = { /*TODO*/ }) {
        Text(
            text = text
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginPreview() {
    LoginScreen()
}