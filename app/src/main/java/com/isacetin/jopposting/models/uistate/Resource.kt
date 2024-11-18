package com.isacetin.jopposting.models.uistate

import androidx.annotation.StringRes
import com.isacetin.jopposting.R
import com.isacetin.jopposting.util.convert

sealed class Resource<T> {
    data class Success<T>(
        val data: T,
        @StringRes val message: Int = R.string.success_general
    ) : Resource<T>()

    data class Error<T>(val error: ErrorType) : Resource<T>()
}

fun Resource.Success<*>.toUiState(showToast: Boolean = false): UiState =
    UiState.Loaded(data = this.data, message = this.message, showToast = showToast)

fun Resource.Error<*>.toUiState(showToast: Boolean = true): UiState =
    UiState.Error(error = this.error.convert(), showToast = showToast)
