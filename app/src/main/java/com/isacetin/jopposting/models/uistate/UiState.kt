package com.isacetin.jopposting.models.uistate

sealed class UiState {
    data object Loading : UiState()

    data class Success<T>(val data: T) : UiState()

    data class Error(val message: String) : UiState()
}
