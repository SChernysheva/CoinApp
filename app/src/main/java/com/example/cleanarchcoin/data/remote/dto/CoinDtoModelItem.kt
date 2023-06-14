package com.example.cleanarchcoin.data.remote.dto

import com.example.cleanarchcoin.domain.model.CoinModel

data class CoinDtoModelItem(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDtoModelItem.toCoinModel(): CoinModel {
    return CoinModel(id = id,
    is_active=is_active,
    is_new=is_new,
    name=name,
    rank=rank,
    symbol=symbol)
}