package com.example.cleanarchcoin.presentation.coin_detail

import com.example.cleanarchcoin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val data: CoinDetail ?= null,
    val error: String = ""
)
