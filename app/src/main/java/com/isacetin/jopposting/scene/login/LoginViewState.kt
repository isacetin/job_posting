package com.isacetin.jopposting.scene.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue

class LoginViewState {
    var username: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    var password: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))

    val isValid by derivedStateOf { checkInputs() }

    fun usernameValidateInput(value: String): String? =
        when {
            value.isEmpty() -> "Lütfen boş bırakmayınız."
            value.length < 6 -> "Lütfen en az 6 karakter giriniz."
            else -> null
        }

    fun passwordValidateInput(value: String): String? =
        when {
            value.isEmpty() -> "Lütfen boş bırakmayınız."
            value.length < 5 -> "Lütfen en az 5 karakter giriniz."
            else -> null
        }

    private fun checkInputs(): Boolean {
        val userNameError = usernameValidateInput(username.value.text)
        val passwordError = passwordValidateInput(password.value.text)

        return userNameError == null && passwordError == null
    }
}

@Composable
fun rememberLoginViewState(): LoginViewState =
    remember {
        LoginViewState()
    }
