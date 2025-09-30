package com.apptive.project23.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileStat(label: String, value: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Row {
            Spacer(modifier = Modifier.width(4.dp))
            Text(value, fontWeight = FontWeight.Bold)
        }
        Text(label, color = Color.Gray)
    }
}