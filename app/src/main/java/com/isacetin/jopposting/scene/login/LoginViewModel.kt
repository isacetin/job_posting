package com.isacetin.jopposting.scene.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.repository.AuthRepository
import com.isacetin.jopposting.util.customErrorHandler
import com.isacetin.local_preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository, private val userPreference: UserPreference) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState?>(null)
    val uiState = _uiState.asStateFlow()

    fun doLogin(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository
                .authenticate(
                    LoginRequest(password = password, username = username)
                ).customErrorHandler { e ->
                    _uiState.value = UiState.Error(e?.message() ?: "-")
                }.collect { result ->
                    _uiState.value = UiState.Success(result)
                    userPreference.saveToken(result.id_token)
                }
        }
    }
}
