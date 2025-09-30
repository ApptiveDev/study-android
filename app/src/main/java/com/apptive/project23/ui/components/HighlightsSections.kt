package com.apptive.project23.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Commit
import androidx.compose.material.icons.filled.LaptopChromebook
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HighlightsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text("하이라이트", fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HighlightItem(title = "스터디", icon = Icons.Default.LaptopChromebook)
            HighlightItem(title = "프로젝트", icon = Icons.Default.Commit)
            HighlightItem(title = "여행", icon = Icons.Default.TravelExplore)
            
        }
    }
}