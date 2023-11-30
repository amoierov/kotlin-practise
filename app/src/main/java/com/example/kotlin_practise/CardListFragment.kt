package com.example.kotlin_practise

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance1
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexboxLayoutManager


class CardListFragment : BaseFragment() {
    override fun getLayoutRes(): Int = R.layout.fragment_card_list
    private val cardList: MutableList<MyModel> = mutableListOf()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardList.add(modelInstance1)
        cardList.add(modelInstance2)
        val recyclerView: RecyclerView = view.findViewById(R.id.rcCardList)
        val adapter = CardAdapter(cardList, findNavController())
        recyclerView.adapter = adapter
        val layoutManager = FlexboxLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

    }

}