package com.isacetin.jopposting.di

import com.isacetin.jopposting.interceptors.AuthInterceptor
import com.isacetin.jopposting.services.AuthService
import com.isacetin.local_preference.data.UserDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("http://192.168.1.6:8080/api/")
            // .baseUrl("http://10.251.101.138:8080/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    internal fun provideClient(interceptor: AuthInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    internal fun provideInterceptor(
        userDataStore: UserDataStore
    ): AuthInterceptor = AuthInterceptor(userDataStore)
}
