package com.apptive.project23.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun HighlightItem(title: String, icon: ImageVector? = null) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(color = Color(0xFFF5F5F5), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            if (icon != null) {
                Icon(imageVector = icon, contentDescription = title, tint = Color(0xFF616161))
            } else {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = title,
                    tint = Color(0xFF616161)
                )
            }
        }
        Text(title)
    }
}