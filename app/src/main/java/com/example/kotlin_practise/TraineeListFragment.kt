package com.example.kotlin_practise

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.adapters.TraineeAdapter
import com.example.kotlin_practise.databinding.FragmentTraineeListBinding
import com.example.kotlin_practise.models.printTrainees
import com.example.kotlin_practise.models.remoteTrainees
import com.example.kotlin_practise.models.traineesList
import com.google.android.flexbox.FlexboxLayoutManager


class TraineeListFragment : BaseFragment(R.layout.fragment_trainee_list) {

    private val binding by viewBinding(FragmentTraineeListBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shortTraineeList = remoteTrainees(traineesList)
        val adapter = TraineeAdapter(shortTraineeList)
        binding.rcViewTrainees.adapter = adapter
        binding.buttonShowTrainees.setOnClickListener {
            val stage = binding.inputStage.text.toString()
            val targetTraineeList = printTrainees(shortTraineeList, stage.toInt())
            adapter.setData(targetTraineeList)
        }

        val layoutManager = FlexboxLayoutManager(requireContext())
        binding.rcViewTrainees.layoutManager = layoutManager
    }
}