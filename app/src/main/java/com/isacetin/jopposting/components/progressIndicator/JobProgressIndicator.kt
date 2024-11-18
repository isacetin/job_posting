package com.isacetin.jopposting.components.progressIndicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.isacetin.jopposting.ui.theme.Primary

@Composable
fun JobProgressIndicator() {
    Dialog(
        onDismissRequest = {}
    ) {
        Card(
            modifier =
                Modifier
                    .background(color = Color.Transparent)
                    .size(75.dp)
                    .clip(RoundedCornerShape(12.dp))
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color.White, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Primary
                )
            }
        }
    }
}

@Preview
@Composable
private fun JobProgressIndicatorPreview() {
    JobProgressIndicator()
}
