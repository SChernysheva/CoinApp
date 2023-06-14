package com.example.cleanarchcoin.domain.use_cases.get_coin

import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.data.remote.dto.CoinDetailDtoModel.toCoinDetail
import com.example.cleanarchcoin.domain.model.CoinDetail
import com.example.cleanarchcoin.domain.model.CoinModel
import com.example.cleanarchcoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetail>> =
        flow {
            try{
                emit(Resource.Loading())
                val coin=repository.getCoinById(id).toCoinDetail()
                emit(Resource.Success(coin))
            }
            catch (e: HttpException){
                emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error"))
            }
            catch (e: IOException){
                emit(Resource.Error(message = e.localizedMessage ?: "Unexpected message"))
            }
        }
}