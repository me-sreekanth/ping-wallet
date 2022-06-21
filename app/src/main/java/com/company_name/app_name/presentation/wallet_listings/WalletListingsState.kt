package com.company_name.app_name.presentation.wallet_listings

import com.company_name.app_name.domain.model.WalletListing

data class WalletListingsState(
    val wallets: List<WalletListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false
) {
}