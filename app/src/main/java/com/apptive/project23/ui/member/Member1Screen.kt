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
fun Member1Screen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("멘토 이병찬") },
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
            Text("안녕하세요, 멘토 이병찬입니다.", fontWeight = FontWeight.Bold)
            Text("역할: 팀 멘토 / 아키텍처 가이드")
            Text("관심사: 아키텍처, 클린 코드, 코드 리뷰")
            Text("한 줄 소개: 읽기 쉬운 코드가 유지보수의 시작입니다.")
            Text("연락처: mentor.lee@example.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Member1Preview() {
    Project23Theme { Member1Screen(onBack = {}) }
}
