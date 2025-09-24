@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
package com.apptive.project23.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apptive.project23.navigation.Routes
import com.apptive.project23.ui.theme.Project23Theme

@Composable
fun HomeScreen(
    onOpen: (String) -> Unit,
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("23기 자기소개") }) }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("원하는 멤버의 자기소개 페이지로 이동해보세요.", style = MaterialTheme.typography.bodyMedium)

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onOpen(Routes.Member1) }
            ) { Text("멤버 1 페이지") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onOpen(Routes.Member2) }
            ) { Text("멤버 2 페이지") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onOpen(Routes.Member3) }
            ) { Text("멤버 3 페이지") }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onOpen(Routes.Member4) }
            ) { Text("멤버 4 페이지") }
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
