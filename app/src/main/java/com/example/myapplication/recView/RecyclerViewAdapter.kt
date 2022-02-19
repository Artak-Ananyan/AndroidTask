package com.example.myapplication.recView

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.network.Wellsitems

class RecyclerViewAdapter : ListAdapter<Wellsitems, ViewHolder>(WellsitesDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
}

