package com.isacetin.jopposting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.isacetin.jopposting.scene.login.login
import com.isacetin.jopposting.scene.register.register
import com.isacetin.jopposting.scene.register.routeRegister

fun NavGraphBuilder.authGraph(navController: NavController) {
    login(
        onNavigateToRegister = {
            navController.routeRegister()
        }
    )

    register(
        onNavigationClick = {
            navController.popBackStack()
        }
    )
}
