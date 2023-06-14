package com.example.cleanarchcoin.di

import com.example.cleanarchcoin.common.Constans
import com.example.cleanarchcoin.data.remote.CoinApi
import com.example.cleanarchcoin.data.repository.CoinRepositoryImpl
import com.example.cleanarchcoin.domain.repository.CoinRepository
import com.example.cleanarchcoin.domain.use_cases.get_list_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApi(): CoinApi =
        Retrofit.Builder().baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    @Provides
    fun provideRepository(api: CoinApi):CoinRepository =
        CoinRepositoryImpl(api)

}