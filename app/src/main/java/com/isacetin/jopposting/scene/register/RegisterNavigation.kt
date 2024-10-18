package com.isacetin.jopposting.scene.register

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val REGISTER = "register"

fun NavController.routeRegister() {
    navigate(REGISTER)
}

fun NavGraphBuilder.register(onNavigationClick: () -> Unit) {
    composable(REGISTER) {
        RegisterScene(
            onNavigationClick = onNavigationClick
        )
    }
}
