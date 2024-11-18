package com.isacetin.jopposting.components.field

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.R
import com.isacetin.jopposting.ui.theme.DarkGray
import com.isacetin.jopposting.ui.theme.Error
import com.isacetin.jopposting.ui.theme.Gray
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
        TextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .border(
                        BorderStroke(width = 1.dp, color = Gray),
                        shape = RoundedCornerShape(12.dp)
                    ),
            value = value,
            onValueChange = {
                onValueChange.invoke(it)
                errorMessage = validator.invoke(it.text)
            },
            placeholder = { Text(text = label, style = customTypography.titleSmall) },
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
            isError = errorMessage != null,
            colors =
                TextFieldDefaults.colors().copy(
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    errorIndicatorColor = Color.Transparent,
                    errorTextColor = Error
                ),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle.Default.copy(color = DarkGray)
        )

        errorMessage?.let {
            Text(
                modifier = Modifier.padding(start = 6.dp, top = 4.dp),
                text = it,
                style = customTypography.bodySmall,
                color = Error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun JobTextFieldPreview() {
    JobTextField(
        label = "Username",
        value = TextFieldValue(""),
        onValueChange = {},
        validator = {
            null
        }
    )
}
