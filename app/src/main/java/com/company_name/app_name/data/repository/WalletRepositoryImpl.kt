package com.company_name.app_name.data.repository

import com.company_name.app_name.data.local.AppDatabase
import com.company_name.app_name.data.mapper.toWalletListing
import com.company_name.app_name.data.remote.WalletApi
import com.company_name.app_name.domain.model.WalletListing
import com.company_name.app_name.domain.repository.WalletRepository
import com.company_name.app_name.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WalletRepositoryImpl @Inject constructor(
    val api: WalletApi,
    val db: AppDatabase
) : WalletRepository {

    private val dao = db.walletDao

    override suspend fun getWalletListings(): Flow<Resource<List<WalletListing>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val localListings = dao.getWalletListing()
            emit(
                Resource.Success(
                    data = localListings.map { it.toWalletListing() }
                )
            )

            val isDbEmpty = localListings.isEmpty() //&& query.isBlank()
//            val shouldLoadJustFromCache = !isDbEmpty && !fet

            val remoteListings = try {
                val response = api.getWalletListings()
//                response.
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.clearWalletListings()
//                dao.insertWalletListings(
//                    listings.ma
//                )
//                dao.insertWalletListings(
//                    listings.map { it.toCompanyListingEntity() }
//                )
//                emit(Resource.Success(
//                    data = dao
//                        .getWalletListing()
//                        .map { it.toWalletListing() }
//                ))
//                emit(Resource.Loading(false))
            }
        }
    }
}