package com.example.cleanarchcoin.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchcoin.R
import com.example.cleanarchcoin.databinding.ItemCoinBinding
import com.example.cleanarchcoin.databinding.ItemTeamOrTagBinding

class CoinTeamAdapter: RecyclerView.Adapter<CoinTeamAdapter.ViewHolder>()  {
    var list = listOf<String>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemTeamOrTagBinding.bind(view)
        fun bind(item: String){
            binding.name.text=item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinTeamAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team_or_tag, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CoinTeamAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}