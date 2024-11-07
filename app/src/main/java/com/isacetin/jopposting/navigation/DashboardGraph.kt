package com.isacetin.jopposting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.isacetin.jopposting.scene.home.home

fun NavGraphBuilder.dashboardGraph(controller: NavController) {
    home()
}
