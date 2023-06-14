package com.example.cleanarchcoin.domain.use_cases.get_list_coins

import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.data.remote.dto.toCoinModel
import com.example.cleanarchcoin.domain.model.CoinModel
import com.example.cleanarchcoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoinModel() }
            emit(Resource.Success(coins))
        }
        catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error"))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected message"))
        }
    }
}