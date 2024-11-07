package com.isacetin.jopposting.scene.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SPLASH = "splash"

fun NavGraphBuilder.splash(
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit
) {
    composable(SPLASH) {
        SplashScene(
            navigateToLogin = navigateToLogin,
            navigateToHome = navigateToHome
        )
    }
}
