package com.example.kotlin_practise.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.R
import com.example.kotlin_practise.adapters.TraineeAdapter
import com.example.kotlin_practise.databinding.FragmentTraineeListBinding
import com.example.kotlin_practise.models.*
import com.google.android.flexbox.FlexboxLayoutManager


class TraineeListFragment : BaseFragment(R.layout.fragment_trainee_list) {

    private val binding by viewBinding(FragmentTraineeListBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shortTraineeList = traineesList.remoteTrainees()
        val adapter = TraineeAdapter(shortTraineeList)
        binding.rcViewTrainees.adapter = adapter
        binding.buttonShowTrainees.setOnClickListener {
            showTraineesFromStage(shortTraineeList, adapter)
        }
        binding.buttonNextFragmentTraineeList.setOnClickListener {
            navigateTo(R.id.action_traineeListFragment_to_threadFragment)
        }
        val layoutManager = FlexboxLayoutManager(requireContext())
        binding.rcViewTrainees.layoutManager = layoutManager
    }

    private fun showTraineesFromStage (shortTraineeList: MutableList<Trainee>, adapter: TraineeAdapter) {
        val stage = binding.inputStage.text.toString()
        val targetTraineeList = shortTraineeList.printTrainees(stage.toInt())
        adapter.setData(targetTraineeList)
    }
}