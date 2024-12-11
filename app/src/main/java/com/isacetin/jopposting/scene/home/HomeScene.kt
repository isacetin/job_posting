package com.isacetin.jopposting.scene.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.isacetin.jopposting.R
import com.isacetin.jopposting.components.field.JobTextField
import com.isacetin.jopposting.components.scaffold.JobScaffold
import com.isacetin.jopposting.models.home.name
import com.isacetin.jopposting.models.uistate.UiState
import com.isacetin.jopposting.ui.theme.customTypography

@Composable
fun HomeScene(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val user = viewModel.user.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getUser()
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.resetState()
        }
    }

    JobScaffold.WithoutTopBar(
        uiState = uiState.value,
        content = {
            HomeSceneContent(it, "${user.value?.name()}")
        }
    )
}

@Composable
private fun HomeSceneContent(
    paddingValues: PaddingValues,
    username: String
) {
    Column(
        modifier =
            Modifier
                .padding(paddingValues)
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HomePageHeader(
            username = username
        )

        JobTextField(
            label = "Search course",
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Search"
                )
            }
        )
    }
}

@Composable
private fun HomePageHeader(
    username: String
) {
    Box(
        modifier =
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = stringResource(R.string.home_hello),
                    style =
                        customTypography.titleLarge.copy(
                            fontWeight = FontWeight.W400,
                            letterSpacing = 0.5.sp
                        )
                )
                Text(
                    text = username,
                    style =
                        customTypography.headlineLarge.copy(
                            lineHeight = 42.sp,
                            letterSpacing = 1.sp
                        )
                )
            }

            Image(
                modifier =
                    Modifier.clickable {
                    },
                painter = painterResource(R.drawable.ic_notification_button),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScenePreview() {
    JobScaffold.WithoutTopBar(
        uiState = UiState.Empty,
        content = {
            HomeSceneContent(
                paddingValues = it,
                username = "İsa Çetin"
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomePageHeaderPreview() {
    HomePageHeader(
        username = "İsa Çetin"
    )
}
