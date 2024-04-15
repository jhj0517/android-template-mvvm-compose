package com.jhj0517.android_template_mvvm_compose.di

import com.jhj0517.android_template_mvvm_compose.BuildConfig
import com.jhj0517.android_template_mvvm_compose.network.BinanceService
import com.jhj0517.android_template_mvvm_compose.network.Client
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBinanceService(): BinanceService {
        return Client.create(baseUrl = BuildConfig.BinanceBaseURL, service = BinanceService::class.java)
    }

}