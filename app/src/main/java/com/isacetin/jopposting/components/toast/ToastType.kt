package com.isacetin.jopposting.components.toast

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.isacetin.jopposting.ui.theme.Error
import com.isacetin.jopposting.ui.theme.Secondary
import com.isacetin.jopposting.ui.theme.Success
import com.isacetin.jopposting.ui.theme.Warning

enum class ToastType(val color: Color, val icon: ImageVector) {
    SUCCESS(color = Success, icon = Icons.Default.Done),
    ERROR(color = Error, Icons.Default.Close),
    WARNING(color = Warning, Icons.Default.Warning),
    INFO(color = Secondary, Icons.Default.Info)
}
