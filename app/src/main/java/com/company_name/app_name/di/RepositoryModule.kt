package com.company_name.app_name.di

import com.company_name.app_name.data.repository.WalletRepositoryImpl
import com.company_name.app_name.domain.repository.WalletRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWalletRepository(
        walletRepositoryImpl: WalletRepositoryImpl
    ) : WalletRepository
}