package com.example.myapplication.recView

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.network.Wellsitems

class WellsitesDiffCallback : DiffUtil.ItemCallback<Wellsitems>() {

    override fun areItemsTheSame(oldItem: Wellsitems, newItem: Wellsitems): Boolean {
        return oldItem.api == newItem.api
    }

    override fun areContentsTheSame(oldItem: Wellsitems, newItem: Wellsitems): Boolean {
        return oldItem == newItem
    }
}