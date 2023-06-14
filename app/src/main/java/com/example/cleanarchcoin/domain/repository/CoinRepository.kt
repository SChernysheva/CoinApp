package com.example.cleanarchcoin.domain.repository

import com.example.cleanarchcoin.data.remote.dto.CoinDetailDtoModel.CoinDetailDto
import com.example.cleanarchcoin.data.remote.dto.CoinDtoModelItem

interface CoinRepository {
    suspend fun getCoins(): List<CoinDtoModelItem>
    suspend fun getCoinById(id:String): CoinDetailDto
}