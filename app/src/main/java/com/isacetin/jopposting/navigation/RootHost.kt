package com.isacetin.jopposting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

const val LOGIN = "login"

@Composable
fun RootHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = LOGIN
    ) {
        authGraph(navController)
    }
}
