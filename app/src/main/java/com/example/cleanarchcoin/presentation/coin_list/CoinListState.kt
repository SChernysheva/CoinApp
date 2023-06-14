package com.example.cleanarchcoin.presentation.coin_list

import com.example.cleanarchcoin.domain.model.CoinModel

data class CoinListState (
    var isLoading:Boolean = false,
    var data: List<CoinModel> = emptyList(),
    var error: String = ""
        )