package com.isacetin.local_preference.di

import com.isacetin.local_preference.UserPreference
import com.isacetin.local_preference.data.UserDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UserPreferenceModule {
    @Binds
    abstract fun bindUserPreferences(impl: UserDataStore): UserPreference
}
