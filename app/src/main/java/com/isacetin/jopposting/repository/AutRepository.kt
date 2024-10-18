package com.isacetin.jopposting.repository

import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.login.LoginResponse
import com.isacetin.jopposting.services.AuthService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AuthRepository {
    suspend fun authenticate(request: LoginRequest): Flow<LoginResponse>
}

class AutRepositoryImpl @Inject constructor(private val service: AuthService) : AuthRepository {
    override suspend fun authenticate(request: LoginRequest): Flow<LoginResponse> =
        flow {
            emit(service.authenticate(request))
        }
}
