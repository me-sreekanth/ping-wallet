package com.company_name.app_name.presentation.wallet_listings

import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company_name.app_name.domain.repository.WalletRepository
import com.company_name.app_name.util.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletListingsViewModel @Inject constructor(
    private val repository: WalletRepository
): ViewModel(){
    var state by mutableStateOf(WalletListingsState())

    init {
        getWalletListings()
    }

    fun onEvent(event: WalletListingsEvent) {
        when(event) {
            is WalletListingsEvent.Refresh -> {
                getWalletListings(fetchFromRemote = true)
            }

            is WalletListingsEvent.OnSearchQueryChange -> {

            }
        }
    }

    private fun getWalletListings(fetchFromRemote: Boolean = false) {
        viewModelScope.launch {
            repository.getWalletListings().collect { result ->
                when(result) {
                    is Resource.Success -> {
                        result.data?.let {
                            state = state.copy(wallets = result.data)
                        }
                    }
                    is Resource.Error -> Unit
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                }
            }
        }
    }
}