@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.apptive.project23.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.project23.navigation.Routes
import com.apptive.project23.ui.theme.Project23Theme

private data class MemberItem(
    val title: String,      // 이름
    val subtitle: String,   // 멘토/멘티
    val emoji: String,
    val route: String,
    val color: Color
)

@Composable
fun HomeScreen(
    onOpen: (String) -> Unit,
) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("23기 자기소개") }) }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // 멤버 리스트
            val members = remember {
                listOf(
                    MemberItem(title = "이병찬", subtitle = "멘토", emoji = "👨‍🏫", route = Routes.Member1, color = Color(0xFF6C63FF)),
                    MemberItem(title = "구민서", subtitle = "멘티", emoji = "🧑‍💻", route = Routes.Member2, color = Color(0xFF00C2A8)),
                    MemberItem(title = "김민서", subtitle = "멘티", emoji = "🧑‍💻‍", route = Routes.Member3, color = Color(0xFFFF7A59)),
                    MemberItem(title = "최지은", subtitle = "멘티", emoji = "🧑‍💻‍", route = Routes.Member4, color = Color(0xFF3DB2FF)),
                )
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(members) { m ->
                    MemberCard(item = m, onOpen = onOpen)
                }
                item { Spacer(modifier = Modifier.height(8.dp)) }
            }
        }
    }
}

@Composable
private fun MemberCard(item: MemberItem, onOpen: (String) -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpen(item.route) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(item.emoji, fontSize = 28.sp)
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(item.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    AssistChip(
                        onClick = { onOpen(item.route) },
                        label = { Text(item.subtitle) },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = item.color.copy(alpha = 0.16f),
                            labelColor = item.color
                        )
                    )
                }
                Text(
                    when (item.subtitle) {
                        "멘토" -> "23기 안드로이드 멘토"
                        else -> "23기 안드로이드 멘티"
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "자기소개 열기")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    Project23Theme {
        HomeScreen(onOpen = {})
    }
}
