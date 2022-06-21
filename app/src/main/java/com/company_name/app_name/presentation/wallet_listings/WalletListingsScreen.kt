package com.company_name.app_name.presentation.wallet_listings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import javax.inject.Inject

@Composable
@Destination
fun WalletListingsScreen(
    navigator: DestinationsNavigator,
    viewModel: WalletListingsViewModel = hiltViewModel()
) {

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)
    val state = viewModel.state
    Text(text = "My Wallets")
    
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            viewModel.onEvent(WalletListingsEvent.Refresh)
        }
    ) {



        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.wallets.size) {i ->
                val wallet = state.wallets[i]
                WalletItem(
                    wallet = wallet,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { }
                )
                if (i < state.wallets.size) {
                    Divider(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

            }
        }
    }
}