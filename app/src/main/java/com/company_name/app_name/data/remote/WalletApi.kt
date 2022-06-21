package com.company_name.app_name.data.remote

import com.company_name.app_name.domain.model.WalletListing
import okhttp3.ResponseBody
import retrofit2.http.GET

interface WalletApi {

    @GET("wallets")
    suspend fun getWalletListings() : List<WalletListing>

    companion object {
        const val BASE_URL = "https://62a9e1f9371180affbca07a3.mockapi.io/"
        const val API_KEY = ""
    }
}