package com.company_name.app_name.domain.repository

import com.company_name.app_name.domain.model.WalletListing
import com.company_name.app_name.util.Resource
import kotlinx.coroutines.flow.Flow

interface WalletRepository {

    suspend fun getWalletListings() : Flow<Resource<List<WalletListing>>>
}