@file:OptIn(ExperimentalMaterial3Api::class)

package com.apptive.project23.ui.member

import android.icu.text.CaseMap
import android.widget.Space
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Adb
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.project23.R.drawable
import com.apptive.project23.ui.components.HighlightItem
import com.apptive.project23.ui.theme.Project23Theme
import kotlin.collections.mutableMapOf

@Composable
fun Member4Screen(onBack: () -> Unit) {
    var isClicked by remember{ mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("choi_ji") },
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
                            imageVector = Icons.Default.MoreVert, contentDescription = "더보기")
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
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(0xFFE0E0E0), shape = CircleShape)
                        .size(92.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "프로필",
                        tint = Color(0xFF616161),
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                Column {
                    Text(
                        text = "최지은",
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Column {
                            Text(
                                text = "7",
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
                                text = "17",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "팔로워",
                                color = Color.Gray
                            )
                        }
                        Column {
                            Text(
                                text = "27",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "팔로잉",
                                color = Color.Gray
                            )
                        }
                    }
                }
            }

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

                ) {
                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = "github.com/~"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = "notion.so/~"
                        )
                    }


                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                OutlinedButton(
                    onClick = { isClicked = !isClicked }, //isClicked 상태값 변경
                    modifier = Modifier.weight(1f), //비율 맞추기 1대 1
                    colors = outlinedButtonColors(
                        contentColor = if (isClicked == true) Color.White else Color.Black,
                        containerColor = if (isClicked == true) Color.Blue else Color.White

                    )
                ) {
                    Text(if (isClicked) "팔로잉" else "팔로우")
                }

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text("메시지")
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
            ) {
                HighlightItem(title = "스터디", Icon = Icons.Default.Laptop)
                HighlightItem(title = "project", Icon = Icons.Default.Laptop)
                HighlightItem(title = "travel", Icon = Icons.Default.Info)
            }

            Column (
                verticalArrangement = Arrangement.spacedBy(space = 10.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
                ) { PostItem(icon = Icons.Default.Adb, color = Color.Red)
                    PostItem(icon = Icons.Default.AccessTime, color = Color.Yellow)
                    PostItem(icon = Icons.Default.Laptop, color = Color.Green)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(space = 10.dp)
                ) {
                    PostItem(icon = Icons.Default.Star)
                    PostItem(icon = Icons.Default.Laptop)
                    PostItem(icon = Icons.Default.Laptop)
                }
           }
        }
    }
}

@Composable
fun HighlightItem(title: String, Icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .background(color = Color.LightGray, shape = CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.Laptop,
                contentDescription = "하이라이트"
            )
        }
        Text(
            text = title

        )
    }
}

@Composable
fun PostItem(icon: ImageVector, color: Color = Color.White) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(color = color, shape = RectangleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "게시글"
            )
        }
    }
}
