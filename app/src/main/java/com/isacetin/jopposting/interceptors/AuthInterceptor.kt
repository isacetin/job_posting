package com.isacetin.jopposting.interceptors

import com.isacetin.local_preference.data.UserDataStore
import jakarta.inject.Inject
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.net.ssl.HttpsURLConnection

class AuthInterceptor @Inject constructor(private val dataStore: UserDataStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val currentRequest = chain.request().newBuilder()

        val token =
            runBlocking {
                dataStore.token().firstOrNull()
            }

        if (!token.isNullOrBlank()) {
            currentRequest.addHeader("Authorization", "Bearer $token")
        }

        val newRequest = currentRequest.build()
        val response = chain.proceed(newRequest)

        if (response.code == HttpsURLConnection.HTTP_UNAUTHORIZED) {
            runBlocking {
                dataStore.saveToken("")
            }
        }

        return response
    }
}
