package com.example.cleanarchcoin.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchcoin.domain.model.CoinModel

class CoinListDiffCallBack(
    val oldList: List<CoinModel>,
    val newList: List<CoinModel>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}