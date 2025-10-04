@file:OptIn(ExperimentalMaterial3Api::class)

package com.apptive.project23.ui.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.project23.ui.theme.Project23Theme

@Composable

fun Member3Screen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("xhdlf_k") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "더보기"
                        )

                    }
                }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp), // 텍스트 사이사이 넓이


        ) {

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Box( // 프로필 아이콘 하나이므로 옆에 글자를 쓸려면 box를 감싸는 row를 생성
                    modifier = Modifier
                        .background(color = Color(0xFFE0E0E0), shape = CircleShape)
                        .size(92.dp), // Customcolor.gray100 200 300..
                    contentAlignment = Alignment.Center
                ) { // import alt + Enter
                    Icon(
                        imageVector = Icons.Filled.Person, // person, color 하나하나 import
                        contentDescription = "프로필",
                        tint = Color(0xFF616161),
                        modifier = Modifier.size(48.dp)
                    )

                }
                Spacer(modifier = Modifier.width(24.dp))
                Column {
                    Text(
                        text = "김민서",
                        fontWeight = FontWeight.Bold,

                        )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row ( // 각 column 마다 그 윗줄에 spacer을 둬도 돼지만 그것들의 부모인 Row의 속성에 추가
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ){
                        Column {
                            Text(
                                text = "1",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "게시물",
                                color = Color.Gray
                            )
                        }
                        Column {
                            Text(
                                text = "100",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 4.dp)

                            )
                            Text(
                                text = "팔로잉",
                                color = Color.Gray
                            )
                        }
                        Column {
                            Text(
                                text = "100",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "팔로워",
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Member3Preview() {
    Project23Theme { Member3Screen(onBack = {}) }
}
