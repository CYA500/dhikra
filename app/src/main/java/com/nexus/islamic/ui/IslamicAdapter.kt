package com.nexus.islamic.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nexus.islamic.data.IslamicEntity
import com.nexus.islamic.databinding.ItemCardBinding

class IslamicAdapter(private val items: List<IslamicEntity>) : 
    RecyclerView.Adapter<IslamicAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvCardContent.text = item.content
        holder.binding.tvCardType.text = item.type
        holder.binding.tvCardSource.text = "[ ${item.source} ]"
    }

    override fun getItemCount() = items.size
}
