package com.isacetin.jopposting.scene.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val PROFILE = "profile"

fun NavController.navigateToProfile() {
    navigate(PROFILE)
}

fun NavGraphBuilder.profile() {
    composable(PROFILE) {
        ProfileScene()
    }
}
