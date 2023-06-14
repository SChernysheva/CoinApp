package com.example.cleanarchcoin.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.cleanarchcoin.App.CoinApp
import com.example.cleanarchcoin.R
import com.example.cleanarchcoin.databinding.ActivityMainBinding
import com.example.cleanarchcoin.di.DaggerAppComponent
import com.example.cleanarchcoin.domain.repository.CoinRepository
import com.example.cleanarchcoin.domain.use_cases.get_list_coins.GetCoinsUseCase
import com.example.cleanarchcoin.presentation.CoinListViewModel
import com.example.cleanarchcoin.presentation.coin_detail.CoinDetailVMFabric
import com.example.cleanarchcoin.presentation.coin_detail.CoinDetailViewModel
import com.example.cleanarchcoin.presentation.coin_list.CoinListVMFabric
import dagger.internal.DaggerGenerated
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val component by lazy {
        (application as CoinApp).component
    }
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var coinListVMFabr: CoinListVMFabric
    @Inject
    lateinit var coinDetailVMFabr: CoinDetailVMFabric


    lateinit var viewmodelList: CoinListViewModel

    lateinit var viewmodelDetail: CoinDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component.inject(this)
        viewmodelList = ViewModelProvider(this, coinListVMFabr)[CoinListViewModel::class.java]
        viewmodelDetail = ViewModelProvider(this, coinDetailVMFabr)[CoinDetailViewModel::class.java]

    }

}