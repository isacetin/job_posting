package com.isacetin.jopposting.scene.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SETTINGS = "settings"

fun NavController.navigateToSettings() {
    navigate(SETTINGS)
}

fun NavGraphBuilder.settings() {
    composable(SETTINGS) {
        SettingsScene()
    }
}
