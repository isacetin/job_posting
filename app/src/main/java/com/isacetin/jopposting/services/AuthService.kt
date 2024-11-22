package com.isacetin.jopposting.services

import com.isacetin.jopposting.models.home.User
import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.login.LoginResponse
import com.isacetin.jopposting.models.register.RegisterRequest
import com.isacetin.jopposting.models.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("/api/authenticate")
    suspend fun authenticate(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("/api/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @GET("/api/user/me")
    suspend fun getUser(): User
}
