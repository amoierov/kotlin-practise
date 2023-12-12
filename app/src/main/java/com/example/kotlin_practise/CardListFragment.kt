package com.example.kotlin_practise

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.adapters.CardAdapter
import com.example.kotlin_practise.databinding.FragmentCardListBinding
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance1
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexboxLayoutManager


class CardListFragment : BaseFragment(R.layout.fragment_card_list) {

    private val cardList: MutableList<MyModel> = mutableListOf()
    private val binding by viewBinding(FragmentCardListBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardList.add(modelInstance1)
        cardList.add(modelInstance2)
        val recyclerView = binding.rcCardList
        val adapter = CardAdapter(cardList
        ) { navigateTo(R.id.action_cardListFragment_to_fileListFragment) }
        recyclerView.adapter = adapter
        val layoutManager = FlexboxLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

    }

}