package com.isacetin.jopposting.scene.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.isacetin.jopposting.R

class OnboardingViewState {
    val onboardingSteps: List<OnboardingStepData> =
        listOf(
            OnboardingStepData(
                image = R.drawable.im_onboarding1,
                title = R.string.onboarding_first_title,
                description = R.string.onboarding_first_description
            ),
            OnboardingStepData(
                image = R.drawable.im_onboarding2,
                title = R.string.onboarding_secondary_title,
                description = R.string.onboarding_secondary_description
            ),
            OnboardingStepData(
                image = R.drawable.im_onboarding3,
                title = R.string.onboarding_third_title,
                description = R.string.onboarding_third_description
            )
        )
}

data class OnboardingStepData(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val description: Int
)
