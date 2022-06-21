package com.company_name.app_name.data.mapper

import com.company_name.app_name.data.local.WalletListingsEntity
import com.company_name.app_name.domain.model.WalletListing

fun WalletListingsEntity.toWalletListing(): WalletListing {
    return WalletListing(
            name = name,
            address = address
            )
}

fun WalletListing.toWalletListingsEntity(): WalletListingsEntity {
    return WalletListingsEntity(
            name = name,
        address = address
            )
}