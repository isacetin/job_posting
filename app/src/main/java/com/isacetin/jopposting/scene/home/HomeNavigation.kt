package com.isacetin.jopposting.scene.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val HOME = "home"

fun NavController.navigateHome() {
    navigate(HOME)
}

fun NavGraphBuilder.home() {
    composable(HOME) {
        HomeScene()
    }
}
