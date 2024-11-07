package com.isacetin.jopposting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.isacetin.jopposting.scene.splash.SPLASH

@Composable
fun RootHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = SPLASH
    ) {
        authGraph(navController)

        dashboardGraph(navController)
    }
}
