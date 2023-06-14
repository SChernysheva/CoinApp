package com.example.cleanarchcoin.domain.model

import com.example.cleanarchcoin.data.remote.dto.CoinDetailDtoModel.Team

data class CoinDetail(
    val coinId: String,
    val name:String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
