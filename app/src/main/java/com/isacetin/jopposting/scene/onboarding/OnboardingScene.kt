package com.isacetin.jopposting.scene.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.isacetin.jopposting.R
import com.isacetin.jopposting.components.button.JobPrimaryButton
import com.isacetin.jopposting.ui.theme.Dark
import com.isacetin.jopposting.ui.theme.DarkGray
import com.isacetin.jopposting.ui.theme.Secondary
import com.isacetin.jopposting.ui.theme.customTypography
import kotlinx.coroutines.launch

@Composable
fun OnboardingScene(
    viewmodel: OnboardingViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit
) {
    val viewState = OnboardingViewState()
    val pagerState = rememberPagerState { viewState.onboardingSteps.size }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.padding(8.dp),
        content = {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it)
            ) {
                OnboardingHeader(
                    viewmodel = viewmodel,
                    onNavigateToLogin = onNavigateToLogin
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    HorizontalPager(
                        state = pagerState
                    ) { index ->
                        OnboardingContent(viewState, index)
                    }

                    OnboardingFooter(pagerState, viewState)
                }
            }
        },
        bottomBar = {
            val isLastOnboardingStep = (pagerState.currentPage + 1 == viewState.onboardingSteps.size)

            JobPrimaryButton(
                modifier = Modifier.padding(bottom = 50.dp, start = 32.dp, end = 32.dp),
                onClick = {
                    if (pagerState.currentPage + 1 < viewState.onboardingSteps.size) {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1,
                                animationSpec =
                                    spring(
                                        dampingRatio = Spring.DampingRatioNoBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                            )
                        }
                    }

                    if (isLastOnboardingStep) {
                        viewmodel.saveFirstLaunch()
                        onNavigateToLogin.invoke()
                    }
                },
                text =
                    if (!isLastOnboardingStep) {
                        stringResource(R.string.onboarding_next)
                    } else {
                        stringResource(R.string.onboarding_let_start)
                    }
            )
        }
    )
}

@Composable
private fun OnboardingHeader(
    viewmodel: OnboardingViewModel,
    onNavigateToLogin: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier =
                Modifier
                    .padding(end = 16.dp, top = 16.dp)
                    .clickable {
                        viewmodel.saveFirstLaunch()
                        onNavigateToLogin.invoke()
                    },
            text = stringResource(R.string.onboarding_skip),
            style =
                customTypography.bodyMedium.copy(
                    color = DarkGray
                )
        )
    }
}

@Composable
private fun OnboardingContent(
    viewState: OnboardingViewState,
    index: Int
) {
    Column(
        modifier = Modifier.wrapContentSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier =
                Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.5f),
            painter = painterResource(viewState.onboardingSteps[index].image),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = stringResource(viewState.onboardingSteps[index].title),
            style =
                customTypography.headlineMedium.copy(
                    color = Dark
                )
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 17.dp, end = 17.dp),
            textAlign = TextAlign.Center,
            text = stringResource(viewState.onboardingSteps[index].description),
            style =
                customTypography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = DarkGray
                )
        )
    }
}

@Composable
private fun OnboardingFooter(
    pagerState: PagerState,
    viewState: OnboardingViewState
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        PageIndicator(
            currentPage = pagerState.currentPage,
            totalPages = viewState.onboardingSteps.size
        )
    }
}

@Composable
private fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPages) { index ->
            val width by animateDpAsState(
                targetValue = if (index == currentPage) 16.dp else 6.dp,
                label = ""
            )
            val height by animateDpAsState(
                targetValue = if (index == currentPage) 6.dp else 6.dp,
                label = ""
            )
            val color by animateColorAsState(
                targetValue = if (index == currentPage) Secondary else Color(0xFFD5D4D4),
                label = ""
            )

            Box(
                modifier =
                    Modifier
                        .width(width)
                        .height(height)
                        .background(color, shape = RoundedCornerShape(4.dp))
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingScenePreview() {
    val viewState = OnboardingViewState()
    val pagerState = rememberPagerState { viewState.onboardingSteps.size }

    Scaffold(
        modifier = Modifier.padding(8.dp),
        content = {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(it)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        modifier =
                            Modifier
                                .padding(end = 16.dp, top = 16.dp),
                        text = stringResource(R.string.onboarding_skip),
                        style =
                            customTypography.bodyMedium.copy(
                                color = DarkGray
                            )
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    HorizontalPager(
                        state = pagerState
                    ) { index ->
                        OnboardingContent(viewState, index)
                    }

                    OnboardingFooter(pagerState, viewState)
                }
            }
        },
        bottomBar = {
            JobPrimaryButton(
                modifier = Modifier.padding(bottom = 50.dp, start = 32.dp, end = 32.dp),
                onClick = {},
                text = stringResource(R.string.onboarding_next)
            )
        }
    )
}

@Preview
@Composable
private fun PageIndicatorPreview() {
    PageIndicator(
        totalPages = 3,
        currentPage = 1
    )
}
