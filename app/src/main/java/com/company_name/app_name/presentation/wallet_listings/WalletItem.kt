package com.company_name.app_name.presentation.wallet_listings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.company_name.app_name.domain.model.WalletListing

@Composable
fun WalletItem(
    wallet: WalletListing,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = wallet.name)
        Text(text = wallet.address)
    }

}