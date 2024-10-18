package com.isacetin.jopposting.components.field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.R
import com.isacetin.jopposting.ui.theme.Error
import com.isacetin.jopposting.ui.theme.JopPostingTheme
import com.isacetin.jopposting.ui.theme.customTypography

@Composable
fun JobTextField(
    value: TextFieldValue = TextFieldValue(),
    onValueChange: (TextFieldValue) -> Unit = {},
    label: String,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    validator: (String) -> String? = { _ -> null },
    isPasswordField: Boolean = false
) {
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isPasswordVisible by remember { mutableStateOf<Boolean>(isPasswordField) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onValueChange.invoke(it)
                errorMessage = validator.invoke(it.text)
            },
            label = { Text(text = label, style = customTypography.titleSmall) },
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            trailingIcon = {
                if (isPasswordField) {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            painter =
                                if (isPasswordVisible) {
                                    painterResource(id = R.drawable.password_icons)
                                } else {
                                    painterResource(
                                        id = R.drawable.password_icons_visible
                                    )
                                },
                            contentDescription = ""
                        )
                    }
                }
            },
            visualTransformation =
                if (!isPasswordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            isError = errorMessage != null
        )

        errorMessage?.let {
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = it,
                style = customTypography.labelMedium,
                color = Error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun JobTextFieldPreview() {
    JopPostingTheme {
        JobTextField(
            label = "Username",
            value = TextFieldValue(""),
            onValueChange = {},
            validator = {
                null
            }
        )
    }
}
