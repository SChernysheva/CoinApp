package com.example.cleanarchcoin.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchcoin.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cleanarchcoin.domain.use_cases.get_list_coins.GetCoinsUseCase
import com.example.cleanarchcoin.presentation.CoinListViewModel
import com.example.cleanarchcoin.presentation.coin_detail.CoinDetailViewModel
import javax.inject.Inject


class CoinListVMFabric @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val viewModel = when (modelClass) {
                CoinListViewModel::class.java -> {
                    CoinListViewModel(getCoinsUseCase)
                }
                else -> {
                    throw IllegalStateException("Unknown view model class")
                }
            }
            return viewModel as T
        }
}