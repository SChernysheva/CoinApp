package com.example.cleanarchcoin.presentation.coin_detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchcoin.domain.repository.CoinRepository
import com.example.cleanarchcoin.domain.use_cases.get_coin.GetCoinUseCase
import javax.inject.Inject

class CoinDetailVMFabric @Inject constructor(
    private val useCase: GetCoinUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            CoinDetailViewModel::class.java -> {
                CoinDetailViewModel(useCase)
            }
            else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}