package com.isacetin.jopposting.scene.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.local_preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val userPreference: UserPreference) : ViewModel() {
    fun saveFirstLaunch() {
        viewModelScope.launch {
            userPreference.saveFirstLaunch()
        }
    }
}
