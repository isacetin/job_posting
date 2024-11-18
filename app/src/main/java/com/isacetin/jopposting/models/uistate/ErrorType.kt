package com.isacetin.jopposting.models.uistate

sealed class ErrorType {
    sealed class Api : ErrorType() {
        data object Network : Api()

        data class BadRequest(val errorText: String) : Api()

        data class Unauthorized(val errorText: String) : Api()

        data object ServiceUnavailable : Api()

        data object NotFound : Api()

        data object Server : Api()
    }

    data object Unknown : ErrorType()
}
