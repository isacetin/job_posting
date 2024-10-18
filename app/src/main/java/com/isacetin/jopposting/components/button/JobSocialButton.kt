package com.isacetin.jopposting.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isacetin.jopposting.R
import com.isacetin.jopposting.ui.theme.Secondary
import com.isacetin.jopposting.ui.theme.White

@Composable
fun JobSocialButton(
    modifier: Modifier = Modifier,
    icon: SocialButtonType,
    onClick: () -> Unit = {}
) {
    Box(
        modifier =
            modifier
                .clip(RoundedCornerShape(10.dp))
                .clickable { onClick.invoke() }
                .size(50.dp)
                .background(Secondary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(15.dp),
            tint = White,
            painter = painterResource(id = icon.type),
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun JobSocialButtonFacebook() {
    JobSocialButton(icon = SocialButtonType.FACEBOOK, onClick = {})
}

@Composable
@Preview(showBackground = true)
private fun JobSocialButtonInstagram() {
    JobSocialButton(icon = SocialButtonType.INSTAGRAM, onClick = {})
}

@Composable
@Preview(showBackground = true)
private fun JobSocialButtonGoogle() {
    JobSocialButton(icon = SocialButtonType.GOOGLE, onClick = {})
}

enum class SocialButtonType(
    @DrawableRes var type: Int
) {
    FACEBOOK(R.drawable.facebook_icon),
    INSTAGRAM(R.drawable.instagram_icon),
    GOOGLE(R.drawable.google_icon)
}
