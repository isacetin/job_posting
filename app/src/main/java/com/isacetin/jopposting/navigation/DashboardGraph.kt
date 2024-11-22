package com.isacetin.jopposting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.isacetin.jopposting.scene.dashboard.dashboard
import com.isacetin.jopposting.scene.home.home
import com.isacetin.jopposting.scene.profile.profile
import com.isacetin.jopposting.scene.settings.settings

fun NavGraphBuilder.dashboardGraph(controller: NavController) {
    dashboard()
    home()
    profile()
    settings()
}
