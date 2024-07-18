package com.apptive.layout.jinseo.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.apptive.layout.ui.theme.LayoutTheme

@Composable
fun HomeScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Home",
            style = TextStyle(fontSize = 40.sp)
        )
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomePreview() {
        HomeScreen()
    }
