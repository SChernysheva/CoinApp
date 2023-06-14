package com.example.cleanarchcoin.data.remote


import com.example.cleanarchcoin.data.remote.dto.CoinDetailDtoModel.CoinDetailDto
import com.example.cleanarchcoin.data.remote.dto.CoinDtoModelItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDtoModelItem>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coin_id:String): CoinDetailDto
}
