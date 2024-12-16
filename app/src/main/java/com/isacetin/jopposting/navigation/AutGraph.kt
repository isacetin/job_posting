package com.isacetin.jopposting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.isacetin.jopposting.scene.dashboard.navigateToDashboard
import com.isacetin.jopposting.scene.login.LOGIN
import com.isacetin.jopposting.scene.login.login
import com.isacetin.jopposting.scene.login.navigateLogin
import com.isacetin.jopposting.scene.onboarding.ONBOARDING
import com.isacetin.jopposting.scene.onboarding.navigateToOnboarding
import com.isacetin.jopposting.scene.onboarding.onboarding
import com.isacetin.jopposting.scene.register.register
import com.isacetin.jopposting.scene.register.routeRegister
import com.isacetin.jopposting.scene.splash.SPLASH
import com.isacetin.jopposting.scene.splash.splash

fun NavGraphBuilder.authGraph(navController: NavController) {
    splash(
        navigateToHome = {
            navController.popBackStack(SPLASH, true)
            navController.navigateToDashboard()
        },
        navigateToLogin = {
            navController.popBackStack(SPLASH, true)
            navController.navigateLogin()
        },
        navigateToOnboarding = {
            navController.popBackStack(SPLASH, true)
            navController.navigateToOnboarding()
        }
    )

    onboarding(
        onNavigateToLogin = {
            navController.popBackStack(ONBOARDING, true)
            navController.navigateLogin()
        }
    )

    login(
        onNavigateToRegister = {
            navController.routeRegister()
        },
        onNavigateToHome = {
            navController.popBackStack(LOGIN, true)
            navController.navigateToDashboard()
        }
    )

    register(
        onNavigationClick = {
            navController.popBackStack()
        }
    )
}
