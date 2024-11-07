package com.isacetin.jopposting.components.scaffold

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.isacetin.jopposting.components.progressIndicator.JobProgressIndicator
import com.isacetin.jopposting.components.toast.JobToast
import com.isacetin.jopposting.components.topbar.JopTopBar
import com.isacetin.jopposting.models.uistate.UiState

object JopScaffold {
    @Composable
    fun Main(
        uiState: UiState?,
        modifier: Modifier = Modifier,
        bottomBar: @Composable () -> Unit = {},
        content: @Composable ((PaddingValues) -> Unit),
        title: String? = null,
        onNavigationClick: () -> Unit = {},
        isScrollable: Boolean = false
    ) {
        Scaffold(
            modifier =
                if (isScrollable) {
                    modifier
                        .imePadding()
                        .verticalScroll(rememberScrollState())
                } else {
                    modifier.imePadding()
                },
            topBar = {
                JopTopBar(
                    title = title,
                    onNavigationClick = onNavigationClick
                )
            },
            bottomBar = bottomBar,
            snackbarHost = {},
            floatingActionButton = {},
            floatingActionButtonPosition = FabPosition.End,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColorFor(AlertDialogDefaults.containerColor),
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
            content = {
                when (uiState) {
                    is UiState.Error -> {
                        content(it)
                        JobToast(
                            uiState.message,
                            paddingValues = it
                        )
                    }

                    UiState.Loading -> {
                        content(it)
                        JobProgressIndicator()
                    }

                    is UiState.Success<*> -> {
                        content(it)
                    }

                    null -> {
                        content(it)
                    }
                }
            }
        )
    }

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun WithoutTopBar(
        uiState: UiState?,
        modifier: Modifier = Modifier,
        bottomBar: @Composable () -> Unit = {},
        content: @Composable ((PaddingValues) -> Unit),
        isScrollable: Boolean = true
    ) {
        Scaffold(
            modifier =
                if (isScrollable) {
                    modifier
                        .imePadding()
                } else {
                    modifier.imePadding()
                },
            topBar = {},
            bottomBar = bottomBar,
            snackbarHost = {},
            floatingActionButton = {},
            floatingActionButtonPosition = FabPosition.End,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColorFor(AlertDialogDefaults.containerColor),
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
            content = {
                when (uiState) {
                    is UiState.Error -> {
                        content(it)
                        JobToast(
                            uiState.message,
                            paddingValues = it
                        )
                    }

                    UiState.Loading -> {
                        content(it)
                        JobProgressIndicator()
                    }

                    is UiState.Success<*> -> {
                        content(it)
                    }

                    null -> {
                        content(it)
                    }
                }
            }
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun JopScaffoldPreview() {
    JopScaffold.Main(
        modifier = Modifier,
        bottomBar = {},
        content = {},
        uiState = UiState.Error("Error error")
    )
}
