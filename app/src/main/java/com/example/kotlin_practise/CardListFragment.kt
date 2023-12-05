package com.example.kotlin_practise

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.adapters.CardAdapter
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance1
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexboxLayoutManager


class CardListFragment : BaseFragment(R.layout.fragment_card_list) {

    private val cardList: MutableList<MyModel> = mutableListOf()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardList.add(modelInstance1)
        cardList.add(modelInstance2)
        val recyclerView: RecyclerView = view.findViewById(R.id.rcCardList)
        val adapter = CardAdapter(cardList
        ) { navigateTo(R.id.action_cardListFragment_to_fileListFragment) }
        recyclerView.adapter = adapter
        val layoutManager = FlexboxLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

    }

}