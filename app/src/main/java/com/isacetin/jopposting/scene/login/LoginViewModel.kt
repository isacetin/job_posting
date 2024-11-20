package com.isacetin.jopposting.scene.login

import androidx.lifecycle.viewModelScope
import com.isacetin.jopposting.models.BaseViewModel
import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.uistate.Resource
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.models.uistate.toUiState
import com.isacetin.jopposting.repository.AuthRepository
import com.isacetin.jopposting.util.toErrorType
import com.isacetin.local_preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository, private val userPreference: UserPreference) : BaseViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState>
        get() = _uiState.asStateFlow()

    fun doLogin(
        username: String,
        password: String
    ) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository
                .authenticate(
                    LoginRequest(password = password, username = username)
                ).catch { e ->
                    emit(Resource.Error(e.toErrorType()))
                }.collect { result ->
                    when (result) {
                        is Resource.Error -> _uiState.value = result.toUiState()
                        is Resource.Success -> {
                            _uiState.value = result.toUiState()
                            userPreference.saveToken(result.data.id_token)
                        }
                    }
                }
        }
    }

    override fun resetState() {
        _uiState.value = UiState.Empty
    }
}
