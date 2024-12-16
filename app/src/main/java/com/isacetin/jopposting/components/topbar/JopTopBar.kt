package com.isacetin.jopposting.components.topbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.isacetin.jopposting.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JopTopBar(
    title: String? = null,
    onNavigationClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            title?.let {
                Text(title)
            }
        },
        modifier = Modifier,
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavigationClick.invoke()
                },
                content = {
                    Icon(
                        painter = painterResource(R.drawable.ic_previos_button),
                        contentDescription = null
                    )
                }
            )
        },
        actions = { },
        windowInsets = TopAppBarDefaults.windowInsets,
        colors =
            TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            ),
        scrollBehavior = null
    )
}

@Composable
@Preview
private fun JopTopBarPreview() {
    JopTopBar(
        title = "Profile"
    )
}
