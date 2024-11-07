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

    init {
        checkLoggedIn()
    }

    private fun checkLoggedIn() {
        viewModelScope.launch {
            userPreference.token().collect { token ->
                if (token.isNotBlank()) {
                    delay(3000)
                    isLogged.value = true
                }
            }
        }
    }
}
