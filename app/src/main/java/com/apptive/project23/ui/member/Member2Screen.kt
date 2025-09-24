@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.apptive.project23.ui.member

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.project23.ui.theme.Project23Theme

@Composable
fun Member2Screen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("멤버 2") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "뒤로가기")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier.fillMaxSize().padding(inner).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("안녕하세요, 멤버 2입니다.", fontWeight = FontWeight.Bold)
            Text("관심사: 네트워킹, 상태 관리")
            Text("한 줄 소개: 안정적인 데이터 흐름을 만듭니다.")
            Text("연락처: example2@email.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Member2Preview() {
    Project23Theme { Member2Screen(onBack = {}) }
}
