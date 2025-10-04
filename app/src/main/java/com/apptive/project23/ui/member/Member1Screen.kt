@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.apptive.project23.ui.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.project23.ui.components.HighlightsSection
import com.apptive.project23.ui.components.PostGridRow
import com.apptive.project23.ui.components.ProfileStat
import com.apptive.project23.ui.theme.Project23Theme

@Composable // UI를 그리는 함수라는 의미
fun Member1Screen(onBack: () -> Unit) { // 매개변수도 없고 반환값도 없는 함수
    val scrollState = rememberScrollState() // 스크롤 상태 기억하는 상태 객체 (재컴포지션이 일어나도 같은 객체를 유지)
    var isFollowing by remember { mutableStateOf(true) } // 상태변수, remember{..} 안의 값도 마찬가지로 재컴포지션이 일어나도 유지된다.(재컴포지션은 상태가 변경될때마다 일어남)
    Scaffold(
        topBar = { // Scaffold 매개변수 중 하나
            TopAppBar( // Material3에서 제공하는 상단 앱바 컴포넌트 (title,navigation,actions) 3가지 슬롯 제공
                title = { Text("bong_chanii", fontWeight = FontWeight.SemiBold) },
                navigationIcon = { // 항상 왼쪽에 배치
                    IconButton(onClick = onBack) { // 터치가능한 버튼
                        Icon( // 실제 Icon UI
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                actions = { // 항상 오른쪽에 배치
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "옵션")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize() // 부모 허용 공간 가로x세로 꽉 채움
                .padding(inner) // Scaffold의 innerPadding 그대로 반영(TopAppBar,BottomBar 영역과 겹치지 않게함)
                .verticalScroll(scrollState) // 세로 스크롤 기능 scrollState로 상태 기억(scrollState가 없으면 UI의 변화가 생기면 재호출 반복되면서 스크롤안됨)
                .padding(horizontal = 20.dp, vertical = 16.dp), // 수평 20, 수직 16 패딩
            verticalArrangement = Arrangement.spacedBy(20.dp) // 자식들 간 간격 조절
        ) {

            Row( // 프로필 정보
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically, // 수직 가운데
                horizontalArrangement = Arrangement.Start // 수평 왼쪽 시작
            ) {
                Box( // 프로필 사진
                    modifier = Modifier
                        .size(92.dp) // 컨테이너 사이즈
                        .background(color = Color(0xFFE0E0E0), shape = CircleShape), // 배경색, 모양(원형)
                    contentAlignment = Alignment.Center // 자식들 가운데 정렬
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "프로필",
                        tint = Color(0xFF616161),
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))

                Column { // 이름 및 게시물, 팔로워, 팔로잉 갯수
                    Text("이병찬", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        // 게시물, 팔로워, 팔로잉 갯수
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                    ) {
                        ProfileStat(label = "게시물", value = "3") // 사용자 정의 컴포저블
                        Spacer(modifier = Modifier.width(30.dp))
                        ProfileStat(label = "팔로워", value = "325")
                        Spacer(modifier = Modifier.width(30.dp))
                        ProfileStat(label = "팔로잉", value = "374")
                    }
                }

            }

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),

                ) { // 인스타 정보란
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Filled.Link,
                        contentDescription = "링크",
                        tint = Color(0xFF616161),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text("https://github.com/mark77234")
                }
            }

            Row( // 팔로우, 메시지 버튼
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { isFollowing = !isFollowing }, // isFollowing 상태값 변경
                    modifier = Modifier.weight(1f), // 1f는 비율단위
                    colors = androidx.compose.material3.ButtonDefaults.outlinedButtonColors(
                        containerColor = if (isFollowing) Color(0xFFEEEEEE) else Color(0xFF1976D2), // isFollowing true -> 회색, false -> 파란색
                        contentColor = if (isFollowing) Color.Black else Color.White // 텍스트 색상도 마찬가지
                    )
                ) {
                    Text(if (isFollowing) "팔로잉" else "팔로우")
                }
                OutlinedButton(onClick = { /* TODO: 메시지 */ }, modifier = Modifier.weight(1f)) {
                    Text("메시지")
                }
            }

            HighlightsSection() // 하이라이트 색션

            Text("게시물", fontWeight = FontWeight.Bold)

            PostGridRow()
            PostGridRow()
            PostGridRow()

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Member1Preview() {
    Project23Theme { Member1Screen(onBack = {}) }
}
