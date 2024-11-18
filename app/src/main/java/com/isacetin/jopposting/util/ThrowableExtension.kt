package com.isacetin.jopposting.util

import com.google.gson.Gson
import com.isacetin.jopposting.models.register.ResponseError
import com.isacetin.jopposting.models.uistate.ErrorCodes
import com.isacetin.jopposting.models.uistate.ErrorType
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

fun Throwable.toErrorType() =
    when (this) {
        is IOException -> ErrorType.Api.Network
        is HttpException ->
            when (code()) {
                ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFound
                ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
                ErrorCodes.Http.ServiceUnavailable -> ErrorType.Api.ServiceUnavailable
                ErrorCodes.Http.BadRequest -> ErrorType.Api.BadRequest(handleException(this.response()))
                ErrorCodes.Http.Unauthorized -> ErrorType.Api.BadRequest(handleException(this.response()))
                else -> ErrorType.Unknown
            }

        else -> ErrorType.Unknown
    }

fun handleException(response: Response<*>?): String {
    val responseError: ResponseError = Gson().fromJson(response?.errorBody()?.string(), ResponseError::class.java)
    return responseError.detail
}
