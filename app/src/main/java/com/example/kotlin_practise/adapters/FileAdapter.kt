package com.example.kotlin_practise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.R


data class FileItem(val fileName: String,
                   )
class FileAdapter(private val files: List<FileItem>, private val onClick: () -> Unit) : RecyclerView.Adapter<FileAdapter.FileViewHolder>() {

    class FileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fileNameTextView: TextView = itemView.findViewById(R.id.fileNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_file, parent, false)
        return FileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        val fileItem = files[position]
        holder.fileNameTextView.text = fileItem.fileName
        holder.fileNameTextView.setOnClickListener {
            onClick()
        }
    }

    override fun getItemCount(): Int {
        return files.size
    }
}


