package com.isacetin.jopposting.repository

import com.isacetin.jopposting.models.home.User
import com.isacetin.jopposting.models.login.LoginRequest
import com.isacetin.jopposting.models.login.LoginResponse
import com.isacetin.jopposting.models.register.RegisterRequest
import com.isacetin.jopposting.models.register.RegisterResponse
import com.isacetin.jopposting.models.uistate.Resource
import com.isacetin.jopposting.services.AuthService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AuthRepository {
    suspend fun authenticate(request: LoginRequest): Flow<Resource<LoginResponse>>

    suspend fun register(request: RegisterRequest): Flow<Resource<RegisterResponse>>

    suspend fun getUser(): Flow<Resource<User>>
}

class AutRepositoryImpl @Inject constructor(private val service: AuthService) : AuthRepository {
    override suspend fun authenticate(request: LoginRequest): Flow<Resource<LoginResponse>> =
        flow {
            emit(Resource.Success(service.authenticate(request)))
        }

    override suspend fun register(request: RegisterRequest): Flow<Resource<RegisterResponse>> =
        flow {
            emit(Resource.Success(service.register(request)))
        }

    override suspend fun getUser(): Flow<Resource<User>> =
        flow {
            emit(Resource.Success(service.getUser()))
        }
}
