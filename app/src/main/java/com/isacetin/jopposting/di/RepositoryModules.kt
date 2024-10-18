package com.isacetin.jopposting.di

import com.isacetin.jopposting.repository.AutRepositoryImpl
import com.isacetin.jopposting.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AutRepositoryImpl): AuthRepository
}
