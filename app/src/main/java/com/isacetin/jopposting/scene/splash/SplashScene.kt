package com.isacetin.jopposting.scene.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.isacetin.jopposting.R
import com.isacetin.jopposting.ui.theme.customTypography

@Composable
fun SplashScene(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateToHome: () -> Unit = {},
    navigateToLogin: () -> Unit = {}
) {
    val isLoggedIn = viewModel.isLogged

    if (isLoggedIn.value == true) {
        navigateToHome.invoke()
    } else if (isLoggedIn.value == false) {
        navigateToLogin.invoke()
    }

    SplashSceneContent()
}

@Composable
private fun SplashSceneContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = R.drawable.im_splash),
            contentDescription = ""
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = stringResource(R.string.splash_app_name),
            style = customTypography.displayLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScenePreview() {
    SplashSceneContent()
}
