package com.isacetin.jopposting.scene.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LOGIN = "login"

fun NavController.navigateLogin() {
    navigate(LOGIN)
}

fun NavGraphBuilder.login(
    onNavigateToRegister: () -> Unit = {},
    onNavigateToHome: () -> Unit = {}
) {
    composable(LOGIN) {
        LoginScene(
            onNavigateToRegister = onNavigateToRegister,
            onNavigateToHome = onNavigateToHome
        )
    }
}
