package com.example.cleanarchcoin.presentation.coin_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.domain.model.CoinDetail
import com.example.cleanarchcoin.domain.use_cases.get_coin.GetCoinUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinUseCase
):ViewModel() {

    var coin: MutableLiveData<Resource<CoinDetail>> = MutableLiveData()

    fun getCoinDetail(id:String){
        getCoinDetailUseCase(id).onEach { result ->
            coin.postValue(result)
        }.launchIn(viewModelScope)
    }
}