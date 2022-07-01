package com.company_name.app_name.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [WalletListingsEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract val walletDao: WalletDao
}