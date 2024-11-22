package com.isacetin.jopposting.models

import androidx.annotation.DrawableRes
import com.isacetin.jopposting.R

enum class NavBarItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int
) {
    HOME("Anasayfa", R.drawable.ic_home_selected, R.drawable.ic_home_unselected),
    PROFILE("Profil", R.drawable.ic_profile_selected, R.drawable.ic_profile_unselected),
    SETTINGS("Ayarlar", R.drawable.ic_settings_selected, R.drawable.ic_settings_unselected);

    companion object {
        fun getEntries(): Array<NavBarItem> = entries.toTypedArray()
    }
}
