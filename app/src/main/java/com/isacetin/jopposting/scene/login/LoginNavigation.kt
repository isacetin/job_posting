package com.isacetin.jopposting.scene.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.isacetin.jopposting.navigation.LOGIN

fun NavGraphBuilder.login(onNavigateToRegister: () -> Unit = {}) {
    composable(LOGIN) {
        LoginScene(
            onNavigateToRegister = onNavigateToRegister
        )
    }
}
