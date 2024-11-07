package com.isacetin.jopposting.scene.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.jopposting.models.register.RegisterRequest
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.repository.AuthRepository
import com.isacetin.jopposting.util.customErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState?>(null)
    val uiState = _uiState.asStateFlow()

    fun register(
        registerRequest: RegisterRequest
    ) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository
                .register(registerRequest)
                .customErrorHandler { e ->
                    _uiState.value = UiState.Error(e?.message() ?: "")
                }.collect { value ->
                    _uiState.value = UiState.Success(value)
                }
        }
    }
}
