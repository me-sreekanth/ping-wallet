package com.company_name.app_name.domain.repository

import com.company_name.app_name.domain.model.CompanyListing
import com.company_name.app_name.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>
}