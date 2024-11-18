package com.isacetin.jopposting.util

import com.isacetin.jopposting.R
import com.isacetin.jopposting.models.uistate.ErrorText
import com.isacetin.jopposting.models.uistate.ErrorType

fun ErrorType.convert(): ErrorText =
    when (this) {
        ErrorType.Api.NotFound -> ErrorText.StringResource(R.string.error_resource_not_found)
        ErrorType.Api.ServiceUnavailable -> ErrorText.StringResource(R.string.error_service_unavailable)
        ErrorType.Api.Server -> ErrorText.StringResource(R.string.error_server)
        ErrorType.Api.Network -> ErrorText.StringResource(R.string.error_network_unavailable)
        is ErrorType.Api.BadRequest -> ErrorText.ApiErrorText(this.errorText)
        ErrorType.Unknown -> ErrorText.StringResource(R.string.error_general)
        is ErrorType.Api.Unauthorized -> ErrorText.ApiErrorText(this.errorText)
    }
