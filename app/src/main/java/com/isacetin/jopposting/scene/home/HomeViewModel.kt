package com.isacetin.jopposting.scene.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isacetin.jopposting.models.home.User
import com.isacetin.jopposting.models.uistate.Resource
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.models.uistate.toUiState
import com.isacetin.jopposting.repository.AuthRepository
import com.isacetin.jopposting.util.toErrorType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("ktlint:standard:backing-property-naming")
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState>
        get() = _uiState.asStateFlow()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?>
        get() = _user.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() =
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository
                .getUser()
                .catch {
                    emit(Resource.Error(it.toErrorType()))
                }.collect { response ->
                    when (response) {
                        is Resource.Error -> _uiState.value = response.toUiState()
                        is Resource.Success -> {
                            _uiState.value = response.toUiState()
                            _user.value = response.data
                        }
                    }
                }
        }
}
