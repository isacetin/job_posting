package com.isacetin.jopposting.components.toast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun JobToast(
    message: String,
    duration: Int = 1500,
    onDismiss: () -> Unit = {},
    paddingValues: PaddingValues,
    toastType: ToastType
) {
    val visible = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(duration.toLong())
        visible.value = false
        onDismiss()
    }

    if (visible.value) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(paddingValues)
                    .clip(RoundedCornerShape(3.dp))
                    .background(toastType.color)
                    .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    toastType.icon,
                    contentDescription = "",
                    tint = toastType.color,
                    modifier =
                        Modifier
                            .size(24.dp)
                            .background(Color.White)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = message,
                style = typography.bodyMedium.copy(color = Color.White)
            )
        }
    }
}

@Preview
@Composable
private fun JobToastPreviewError() {
    JobToast(
        "Error Error Error",
        paddingValues = PaddingValues(16.dp),
        toastType = ToastType.ERROR
    )
}

@Preview
@Composable
private fun JobToastPreviewSuccess() {
    JobToast(
        "Success Success Success",
        paddingValues = PaddingValues(16.dp),
        toastType = ToastType.SUCCESS
    )
}

@Preview
@Composable
private fun JobToastPreviewWarning() {
    JobToast(
        "Warning Warning Warning",
        paddingValues = PaddingValues(16.dp),
        toastType = ToastType.WARNING
    )
}

@Preview
@Composable
private fun JobToastPreviewInfo() {
    JobToast(
        "Info Info Info",
        paddingValues = PaddingValues(16.dp),
        toastType = ToastType.INFO
    )
}
