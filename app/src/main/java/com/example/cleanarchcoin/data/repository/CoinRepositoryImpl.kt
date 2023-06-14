package com.example.cleanarchcoin.data.repository

import com.example.cleanarchcoin.data.remote.CoinApi
import com.example.cleanarchcoin.data.remote.dto.CoinDetailDtoModel.CoinDetailDto
import com.example.cleanarchcoin.data.remote.dto.CoinDtoModelItem
import com.example.cleanarchcoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api:CoinApi): CoinRepository{

    override suspend fun getCoins(): List<CoinDtoModelItem> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}