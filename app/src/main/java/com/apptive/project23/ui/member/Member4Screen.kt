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
fun Member4Screen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("멘티 최지은") },
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
            Text("안녕하세요, 멘티 최지은입니다!", fontWeight = FontWeight.Bold)
            Text("역할: 멘티 : 백엔드-모바일 연동 학습, 안드로이드 공부")
            Text("관심사: 노래 듣기 / 독서감상문 쓰기 ")
            Text("한 줄 소개: 요즘 일기쓰는데 일기 쓰기 귀찮은 것 같아요. 나 대신 일기 써주는 사람 있었으면 좋겠당ㅎㅎ")
            Text("연락처: 010-3426-0279")
            Text("좋아하는 노래: the beatles - octopus's garden")
            Text("인생목표: 주식천재 되기!!")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Member4Preview() {
    Project23Theme { Member4Screen(onBack = {}) }
}
