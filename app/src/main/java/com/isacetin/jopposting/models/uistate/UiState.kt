package com.isacetin.jopposting.models.uistate

import androidx.annotation.StringRes

sealed class UiState {
    data object Loading : UiState()

    data object Empty : UiState()

    data class Error(val error: ErrorText, val showToast: Boolean = false) : UiState()

    data class Loaded<T>(
        val data: T,
        @StringRes val message: Int,
        var showToast: Boolean = false
    ) : UiState()
}
