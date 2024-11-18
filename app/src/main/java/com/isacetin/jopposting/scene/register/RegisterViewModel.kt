package com.isacetin.jopposting.scene.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.jopposting.models.register.RegisterRequest
import com.isacetin.jopposting.models.uistate.Resource
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.models.uistate.toUiState
import com.isacetin.jopposting.repository.AuthRepository
import com.isacetin.jopposting.util.toErrorType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState = _uiState.asStateFlow()

    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository
                .register(registerRequest)
                .catch {
                    emit(Resource.Error(it.toErrorType()))
                }.collect { value ->
                    when (value) {
                        is Resource.Error -> _uiState.value = value.toUiState()
                        is Resource.Success -> _uiState.value = value.toUiState(showToast = true)
                    }
                }
        }
    }
}
