package com.isacetin.jopposting.models.uistate

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class ErrorText {
    class StringResource(
        @StringRes val id: Int
    ) : ErrorText()

    data class ApiErrorText(val text: String) : ErrorText()

    @Composable
    fun asString() =
        when (this) {
            is StringResource -> stringResource(id)
            is ApiErrorText -> this.text
        }
}
