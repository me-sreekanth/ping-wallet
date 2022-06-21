package com.company_name.app_name.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WalletListingsEntity(
    val name: String,
    val address: String,
    @PrimaryKey val id: Int? = null
) {
}