package com.example.cleanarchcoin.presentation.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.databinding.CoinDetailFragBinding
import com.example.cleanarchcoin.databinding.CoinListFragBinding
import com.example.cleanarchcoin.domain.repository.CoinRepository
import com.example.cleanarchcoin.domain.use_cases.get_coin.GetCoinUseCase
import com.example.cleanarchcoin.presentation.CoinListViewModel
import com.example.cleanarchcoin.presentation.adapters.CoinListAdapter
import com.example.cleanarchcoin.presentation.adapters.CoinTeamAdapter
import com.example.cleanarchcoin.presentation.coin_detail.CoinDetailVMFabric
import com.example.cleanarchcoin.presentation.coin_detail.CoinDetailViewModel
import javax.inject.Inject

class CoinDetailFragment : Fragment() {
    lateinit var viewModel: CoinDetailViewModel
    lateinit var binding: CoinDetailFragBinding
    lateinit var adapter: CoinTeamAdapter
    var list = listOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=CoinDetailFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewmodelDetail
        val id = arguments?.getString("id")
        if (id!=null){
            viewModel.getCoinDetail(id)
        }
        //initRC()
        observer()
    }

    fun initRCTags(){
        adapter= CoinTeamAdapter()
        binding.rcTags.adapter=adapter
        binding.rcTags.layoutManager=LinearLayoutManager(requireContext())
        adapter.list=list
    }

    private fun initRCTeam(){
        adapter= CoinTeamAdapter()
        binding.rcTeamMembers.adapter=adapter
        binding.rcTeamMembers.layoutManager= LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        adapter.list=list
    }
    fun observer(){
        viewModel.coin.observe(viewLifecycleOwner) { responce ->
            when(responce) {
                is Resource.Success -> {
                    binding.pb.visibility=View.INVISIBLE
                    binding.name.text=responce.data?.name
                    binding.description.text=responce.data?.description
                    binding.rank.text="Rank:" + responce.data?.rank.toString()
                    binding.symbol.text=responce.data?.symbol
                    list= responce.data?.team?.map { it.name } ?: emptyList()
                    initRCTeam()
                    list= responce.data?.tags ?: emptyList()
                    initRCTags()
                }
                is Resource.Loading ->{
                    binding.pb.visibility=View.VISIBLE
                }
                is Resource.Error -> {
                    binding.pb.visibility=View.INVISIBLE
                    binding.name.text=responce.message
                }
            }
        }
    }

}