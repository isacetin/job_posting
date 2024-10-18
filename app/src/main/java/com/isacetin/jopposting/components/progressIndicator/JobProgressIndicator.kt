package com.isacetin.jopposting.components.progressIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.isacetin.jopposting.ui.theme.Primary
import com.isacetin.jopposting.ui.theme.Secondary

@Composable
fun JobProgressIndicator() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(color = Secondary.copy(alpha = 0.1f))
                .clickable(enabled = false) {},
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = Primary
        )
    }
}

@Preview
@Composable
private fun JobProgressIndicatorPreview() {
    JobProgressIndicator()
}
