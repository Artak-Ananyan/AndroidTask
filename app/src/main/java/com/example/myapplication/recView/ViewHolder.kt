package com.example.myapplication.recView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardItemBinding
import com.example.myapplication.network.Wellsitems

class ViewHolder private constructor(private val binding: CardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Wellsitems) {
        item.also { binding.data = it }
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CardItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}