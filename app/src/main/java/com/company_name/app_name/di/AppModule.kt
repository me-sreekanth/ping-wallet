package com.company_name.app_name.di

import android.app.Application
import androidx.room.Room
import com.company_name.app_name.data.local.AppDatabase
import com.company_name.app_name.data.remote.WalletApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesWalletApi(): WalletApi {
        return Retrofit.Builder()
            .baseUrl(WalletApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BASIC })
                .build()
            )
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesAppDatabase(app: Application) : AppDatabase {
        return Room.databaseBuilder(app,
        AppDatabase::class.java,
        "walletdb.db")
            .build()
    }
}