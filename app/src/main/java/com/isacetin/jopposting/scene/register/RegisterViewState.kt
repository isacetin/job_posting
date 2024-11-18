package com.isacetin.jopposting.scene.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.isacetin.jopposting.util.isValidEmail

class RegisterViewState {
    val username = mutableStateOf(TextFieldValue(""))
    val name = mutableStateOf(TextFieldValue(""))
    val surname = mutableStateOf(TextFieldValue(""))
    val email = mutableStateOf(TextFieldValue(""))
    val password = mutableStateOf(TextFieldValue(""))

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
            value.length < 6 -> "Lütfen en az 6 karakter giriniz."
            else -> null
        }

    fun emailValidateInput(value: String): String? =
        when {
            value.isEmpty() -> "Lütfen boş bırakmayınız."
            !value.isValidEmail() -> "Lütfen geçerli bir mail adresi giriniz."
            else -> null
        }

    fun emptyValidateInput(value: String): String? =
        when {
            value.isEmpty() -> "Lütfen boş bırakmayınız."
            else -> null
        }

    private fun checkInputs(): Boolean {
        val userNameError = usernameValidateInput(username.value.text)
        val passwordError = passwordValidateInput(password.value.text)
        val emailError = emailValidateInput(password.value.text)
        val nameError = emptyValidateInput(name.value.text)
        val surnameError = emptyValidateInput(surname.value.text)

        return userNameError == null &&
            passwordError == null &&
            emailError == null &&
            nameError == null &&
            surnameError == null
    }
}

@Composable
fun rememberRegisterViewState(): RegisterViewState =
    remember {
        RegisterViewState()
    }
