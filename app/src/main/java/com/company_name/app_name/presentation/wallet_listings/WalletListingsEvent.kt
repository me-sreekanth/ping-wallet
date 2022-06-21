package com.company_name.app_name.presentation.wallet_listings

sealed class WalletListingsEvent {
    object Refresh: WalletListingsEvent()
    data class OnSearchQueryChange(val query: String): WalletListingsEvent()
}