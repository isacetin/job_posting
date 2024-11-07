package com.isacetin.local_preference

import kotlinx.coroutines.flow.Flow

interface UserPreference {
    fun token(): Flow<String>

    suspend fun saveToken(token: String)
}
