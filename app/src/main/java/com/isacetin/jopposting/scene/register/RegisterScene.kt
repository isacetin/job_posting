package com.isacetin.jopposting.scene.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.R
import com.isacetin.jopposting.components.button.JobPrimaryButton
import com.isacetin.jopposting.components.field.JobTextField
import com.isacetin.jopposting.components.scaffold.JopScaffold
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.ui.theme.customTypography

@Composable
fun RegisterScene(
    onNavigationClick: () -> Unit
) {
    val viewState = rememberRegisterViewState()

    JopScaffold.Main(
        onNavigationClick = onNavigationClick,
        uiState = UiState.Error("Error"),
        content = {
            Column(
                modifier =
                    Modifier
                        .padding(it)
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier =
                        Modifier
                            .height(250.dp)
                            .width(250.dp),
                    painter = painterResource(id = R.drawable.im_register),
                    contentDescription = ""
                )

                Text(text = "Kayıt Ol", style = customTypography.titleLarge)

                Text(text = "Hesap oluştur", style = customTypography.titleSmall)

                JobTextField(
                    label = "Kullanıcı Adı",
                    value = viewState.username.value,
                    onValueChange = { value ->
                        viewState.username.value = value
                    },
                    validator = { value -> viewState.usernameValidateInput(value) }
                )
                JobTextField(
                    label = "E-mail",
                    value = viewState.email.value,
                    onValueChange = { value ->
                        viewState.email.value = value
                    },
                    validator = { value -> viewState.emailValidateInput(value) },
                    keyboardOptions =
                        KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                )

                JobTextField(
                    label = "Password",
                    value = viewState.password.value,
                    onValueChange = { value ->
                        viewState.password.value = value
                    },
                    validator = { value -> viewState.passwordValidateInput(value) },
                    isPasswordField = true
                )

                JobPrimaryButton(text = "Kayıt Ol", onClick = {
                    if (viewState.isValid) {
                    } else {
                    }
                })

                Text(
                    modifier =
                        Modifier.clickable {
                            onNavigationClick.invoke()
                        },
                    text = "Giriş Yap",
                    style = customTypography.bodyMedium
                )
            }
        }
    )
}

@Composable
@Preview
private fun RegisterScenePreview() {
    RegisterScene(
        onNavigationClick = {}
    )
}
