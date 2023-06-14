package com.example.cleanarchcoin.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchcoin.R
import com.example.cleanarchcoin.databinding.ItemCoinBinding
import com.example.cleanarchcoin.domain.model.CoinModel

class CoinListAdapter(private val listener: Listener): RecyclerView.Adapter<CoinListAdapter.ViewHolder>()  {
    var list = listOf<CoinModel>()
    set(value) {
        val callback = CoinListDiffCallBack(list, value)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)
        field=value
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemCoinBinding.bind(view)

        fun bind(coin: CoinModel, listener: Listener){
            binding.name.text=coin.name
            binding.rank.text= coin.rank.toString()
            if(coin.is_active) {
                binding.active.text="active"
            }
            else {
                binding.active.text="not active"
            }
            binding.symbol.text=coin.symbol

            itemView.setOnClickListener {
                listener.openDetail(coin.id)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    interface Listener{
        fun openDetail(id: String)
    }
}