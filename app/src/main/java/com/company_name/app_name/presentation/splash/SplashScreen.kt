package com.company_name.app_name.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.company_name.app_name.R
import com.company_name.app_name.presentation.destinations.WalletListingsScreenDestination
import com.company_name.app_name.presentation.wallet_listings.WalletListingsScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@Composable
@Destination(start = true)
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")

        LaunchedEffect(key1 = true, ) {
            delay(1000)
            navigator.navigate(WalletListingsScreenDestination())
        }
    }
}
