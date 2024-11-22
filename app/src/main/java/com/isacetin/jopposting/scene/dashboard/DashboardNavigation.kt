package com.isacetin.jopposting.scene.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val DASHBOARD = "bottomNavigation"

fun NavController.navigateToDashboard() {
    navigate(DASHBOARD)
}

fun NavGraphBuilder.dashboard() {
    composable(DASHBOARD) {
        DashboardScene()
    }
}
