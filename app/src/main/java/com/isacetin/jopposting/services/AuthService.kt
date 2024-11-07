package com.isacetin.jopposting.services

import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.login.LoginResponse
import com.isacetin.jopposting.models.register.RegisterRequest
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/authenticate")
    suspend fun authenticate(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("/api/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response
}
