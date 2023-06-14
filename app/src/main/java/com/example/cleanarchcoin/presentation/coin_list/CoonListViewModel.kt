package com.example.cleanarchcoin.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.domain.model.CoinModel
import com.example.cleanarchcoin.domain.use_cases.get_list_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {

    var coinList: MutableLiveData<Resource<List<CoinModel>>> = MutableLiveData()

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            coinList.value = result
//            when (result) {
//                is Resource.Success -> {
//                    coinList.postValue(result)
//                }
//                is Resource.Loading -> {
//                    coinList.postValue(Resource.Loading())
//                }
//                is Resource.Error -> {
//                    coinList.postValue(Resource.Error( message = result.message ?: "Unexpected error"))
//                }
//            }
        }.launchIn(viewModelScope)
    }

}