package com.isacetin.jopposting.scene.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ONBOARDING = "onboarding"

fun NavController.navigateToOnboarding() {
    navigate(ONBOARDING)
}

fun NavGraphBuilder.onboarding(
    onNavigateToLogin: () -> Unit
) {
    composable(ONBOARDING) {
        OnboardingScene(
            onNavigateToLogin = onNavigateToLogin
        )
    }
}
