package com.company_name.app_name.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WalletDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWalletListings(
        companyListingEntities: List<WalletListingsEntity>
    )

    @Query("DELETE FROM walletlistingsentity")
    suspend fun clearWalletListings()

    @Query(
        "SELECT * FROM walletlistingsentity"
    )
    suspend fun getWalletListing(): List<WalletListingsEntity>
}