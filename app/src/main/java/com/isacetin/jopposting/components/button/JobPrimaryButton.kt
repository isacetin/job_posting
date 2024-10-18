package com.isacetin.jopposting.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.ui.theme.JopPostingTheme
import com.isacetin.jopposting.ui.theme.Primary
import com.isacetin.jopposting.ui.theme.customTypography

@Composable
fun JobPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier =
            modifier.then(
                Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ),
        shape = RoundedCornerShape(8.dp),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Primary
            ),
        content = {
            Text(text = text, style = customTypography.titleMedium)
        }
    )
}

@Preview(name = "Primary Button", showBackground = true)
@Composable
private fun JobPrimaryButtonPreview() {
    JopPostingTheme {
        JobPrimaryButton("Get Started", {})
    }
}
