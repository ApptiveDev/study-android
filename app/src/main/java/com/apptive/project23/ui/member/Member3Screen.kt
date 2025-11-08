@file:OptIn(ExperimentalMaterial3Api::class)

package com.apptive.project23.ui.member

//import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
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
import androidx.compose.material.icons.filled.AirplanemodeActive
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable

fun Member3Screen(onBack: () -> Unit) {

    var scrollState = rememberScrollState()
    var isClicked by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "xhdlf_k",
                        fontWeight = FontWeight.SemiBold
                    )
                },
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
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(20.dp), // 텍스트 사이사이 넓이


        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                    Row( // 각 column 마다 그 윗줄에 spacer을 둬도 돼지만 그것들의 부모인 Row의 속성에 추가
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
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
                                text = "264",
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
                                text = "322",
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
            Column {
                Row(
                    // 가로로 가운데에 위치하도록
                    modifier = Modifier.fillMaxWidth(), // text 크기만큼만 있는데 부모(최상위 Column)를 fillMax로 늘림
                    horizontalArrangement = Arrangement.Center
                )
                {

                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "https://github.com/minseoriii"
                    )
                }


                Row(
                    // 가로로 가운데에 위치하도록
                    modifier = Modifier.fillMaxWidth(), // text 크기만큼만 있는데 부모(최상위 Column)를 fillMax로 늘림 fillMaxSize하면 가로세로 다 최대로 늘어남
                    horizontalArrangement = Arrangement.Center
                )
                {

                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "https://blog.naver.com/minseo_324"
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedButton( //상태변화
                        onClick = { isClicked = !isClicked },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = if (isClicked) Color.White else Color.Black,
                            containerColor = if (isClicked) Color.Blue else Color.White
                        )
                    ) {
                        Text(
                            text = if (isClicked == true) "팔로잉" else "팔로우"
                        )

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "메시지"
                        )

                    }


                }
            }

            Text(
                text = "하이라이트",
                fontWeight = FontWeight.Bold
            )

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {


                Highlightitems(title = "스터디", Icon = Icons.Default.Laptop)
                Highlightitems(title = "프로젝트", Icon = Icons.Default.Book)
                Highlightitems(title = "여행", Icon = Icons.Default.AirplanemodeActive)


            }
            Text(
                text = "게시물",
                fontWeight = FontWeight.Bold
            )
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Postingitems()
                    Postingitems()
                    Postingitems()
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Postingitems()
                    Postingitems()
                    Postingitems()
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Postingitems()
                    Postingitems()
                    Postingitems()
                }



            }


        }


    }

}


@Composable
fun Highlightitems(title: String, Icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(color = Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icon,
                contentDescription = "하이라이트1"

            )
        }

        Text(
            text = title
        )


    }

}

@Composable
fun Postingitems() {

    Box(
        modifier = Modifier
            .size(90.dp)
            .background(Color.LightGray, shape = RectangleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "게시물"

        )
    }


}