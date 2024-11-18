package com.isacetin.jopposting.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

//  Deprecated
fun <T> Flow<T>.customErrorHandler(task: (HttpException?) -> Unit) =
    flow {
        try {
            collect { value ->
                emit(value)
            }
        } catch (e: HttpException) {
            task.invoke(e)
        } catch (e: Exception) {
            task.invoke(null)
        }
    }
