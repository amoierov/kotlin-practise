package com.example.kotlin_practise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.databinding.CardItemBinding
import com.example.kotlin_practise.models.MyModel

class CardAdapter(
    private val cardList: MutableList<MyModel>,
    private val navController: NavController
) : RecyclerView.Adapter<CardAdapter.CardHolder>() {
    class CardHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: MyModel, navController: NavController) {
            if (card.picture) {
                binding.im.visibility = View.VISIBLE
                binding.im.setOnClickListener {
                    navController.navigate(R.id.action_cardListFragment_to_fileListFragment)
                }
            } else {
                binding.im.visibility = View.GONE
            }
            binding.cardUserName.text = card.userName
            binding.cardSign.text = card.signature
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(inflater, parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val card = cardList[position]
        holder.bind(card, navController)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }


}