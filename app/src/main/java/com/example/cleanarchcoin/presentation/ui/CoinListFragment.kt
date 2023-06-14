package com.example.cleanarchcoin.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchcoin.R
import com.example.cleanarchcoin.common.Resource
import com.example.cleanarchcoin.databinding.CoinListFragBinding
import com.example.cleanarchcoin.domain.repository.CoinRepository
import com.example.cleanarchcoin.domain.use_cases.get_list_coins.GetCoinsUseCase
import com.example.cleanarchcoin.presentation.CoinListViewModel
import com.example.cleanarchcoin.presentation.adapters.CoinListAdapter
import com.example.cleanarchcoin.presentation.coin_list.CoinListVMFabric
import javax.inject.Inject

class CoinListFragment: Fragment(), CoinListAdapter.Listener {
    lateinit var viewModel: CoinListViewModel
    lateinit var binding: CoinListFragBinding
    lateinit var adapter: CoinListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CoinListFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewmodelList
        initRc()
        observer()
    }


    private fun initRc(){
        adapter= CoinListAdapter(this)
        binding.recView.adapter=adapter
        binding.recView.layoutManager=LinearLayoutManager(requireContext())
    }

    private fun observer(){
        viewModel.coinList.observe(viewLifecycleOwner) { responce ->
            when (responce) {
                is Resource.Success ->{
                    binding.progressBar.visibility=View.INVISIBLE
                    adapter.list= responce.data ?: emptyList()
                }
                is Resource.Error -> {
                    binding.progressBar.visibility=View.INVISIBLE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility=View.VISIBLE
                }
            }
        }
    }

    override fun openDetail(id: String) {

        val bundle = bundleOf("id" to id)
        findNavController().navigate(R.id.action_coinListFragment_to_coinDetailFragment, bundle)
    }

}