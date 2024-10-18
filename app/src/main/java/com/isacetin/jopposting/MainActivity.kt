package com.isacetin.jopposting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.isacetin.jopposting.navigation.RootHost
import com.isacetin.jopposting.ui.theme.JopPostingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JopPostingTheme {
                RootHost()
            }
        }
    }
}
