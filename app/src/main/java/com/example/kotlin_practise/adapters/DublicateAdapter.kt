package com.example.kotlin_practise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.DublicateItemBinding

class DublicateAdapter(private val hashMapList: HashMap<String, Int>): RecyclerView.Adapter<DublicateAdapter.DublicateViewHolder>() {
    class DublicateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = DublicateItemBinding.bind(itemView)
        fun bind(key: String, value: Int){
            binding.valueText.text = "$key - "
            binding.countValue.text = value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DublicateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dublicate_item, parent, false)
        return DublicateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DublicateViewHolder, position: Int) {
        val entryAtIndex = hashMapList.entries.elementAt(position)
        val key = entryAtIndex.key
        val value = entryAtIndex.value
        holder.bind(key, value)
    }

    override fun getItemCount(): Int {
        return hashMapList.size
    }


}