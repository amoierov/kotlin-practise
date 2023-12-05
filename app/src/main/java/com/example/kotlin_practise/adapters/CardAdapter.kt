package com.example.kotlin_practise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.databinding.CardItemBinding
import com.example.kotlin_practise.models.MyModel

class CardAdapter(
    private val cardList: MutableList<MyModel>,
    private val onClick: () -> Unit
) : RecyclerView.Adapter<CardAdapter.CardHolder>() {
    class CardHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: MyModel, onClick: () -> Unit) {
            if (card.picture) {
                binding.image.visibility = View.VISIBLE
                binding.image.setOnClickListener {
                    onClick()
                }
            } else {
                binding.image.visibility = View.GONE
            }
            binding.cardUserName.text = card.userName
            binding.signUser.text = card.signature
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(inflater, parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card) {onClick()}
    }

    override fun getItemCount(): Int {
        return cardList.size
    }


}