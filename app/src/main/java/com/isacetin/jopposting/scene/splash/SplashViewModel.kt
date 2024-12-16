package com.isacetin.jopposting.scene.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.local_preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userPreference: UserPreference) : ViewModel() {
    val isLogged = mutableStateOf<Boolean?>(null)
    val isFirstLaunch = mutableStateOf(false)

    init {
        checkLoggedIn()
        checkFirstLogin()
    }

    private fun checkLoggedIn() {
        viewModelScope.launch {
            userPreference.token().collect { token ->
                delay(2500L)
                isLogged.value = token.isNotBlank()
            }
        }
    }

    private fun checkFirstLogin() {
        viewModelScope.launch {
            userPreference.isFirstLaunch().collect { result ->
                delay(2500L)
                isFirstLaunch.value = result
            }
        }
    }
}
