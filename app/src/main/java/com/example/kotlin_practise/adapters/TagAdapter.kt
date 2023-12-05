package com.example.kotlin_practise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.TagItemBinding

class TagAdapter(private val tagList: List<String>) :
    RecyclerView.Adapter<TagAdapter.TagViewHolder>() {

    class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = TagItemBinding.bind(itemView)
        fun bind(item: String) {
            binding.tgtext.text = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tag_item, parent, false)
        return TagViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val tag = tagList[position]
        holder.bind(tag)
    }

    override fun getItemCount(): Int {
        return tagList.size
    }
}