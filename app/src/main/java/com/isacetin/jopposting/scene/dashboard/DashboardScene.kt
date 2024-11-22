package com.isacetin.jopposting.scene.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.models.NavBarItem
import com.isacetin.jopposting.scene.home.HomeScene
import com.isacetin.jopposting.scene.profile.ProfileScene
import com.isacetin.jopposting.scene.settings.SettingsScene
import com.isacetin.jopposting.ui.theme.Gray
import com.isacetin.jopposting.ui.theme.Primary
import com.isacetin.jopposting.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScene() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier =
                    Modifier.border(
                        width = 1.dp,
                        color = Gray,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    ),
                containerColor = White,
                contentColor = Primary
            ) {
                NavBarItem.getEntries().forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        modifier = Modifier,
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            val icon = if (selectedIndex == index) navItem.selectedIcon else navItem.unSelectedIcon

                            Image(
                                painter = painterResource(icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = navItem.title
                            )
                        },
                        colors =
                            NavigationBarItemDefaults.colors().copy(
                                selectedTextColor = Primary,
                                unselectedTextColor = Gray,
                                selectedIndicatorColor = Color.Transparent
                            )
                    )
                }
            }
        }
    ) { _ ->
        when (selectedIndex) {
            0 -> HomeScene()
            1 -> ProfileScene()
            2 -> SettingsScene()
            else -> {}
        }
    }
}

@Preview
@Composable
private fun JobBottomNavigationBarPreview() {
    DashboardScene()
}
