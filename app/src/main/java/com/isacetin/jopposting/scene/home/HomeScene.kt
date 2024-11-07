package com.isacetin.jopposting.scene.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScene(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column {
        Text("Home")
    }
}
