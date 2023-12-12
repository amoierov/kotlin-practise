package com.example.kotlin_practise

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.databinding.FragmentInputBinding


class InputFragment : BaseFragment(R.layout.fragment_input) {


    private val binding by viewBinding(FragmentInputBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonInput.setOnClickListener {
            val inputText = binding.editTextDigits.text.toString()
            val numbers = inputText.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()
            binding.textResult.text = numbers.toString()
        }
        binding.buttonNextFragment.setOnClickListener {
            navigateTo(R.id.action_inputFragment_to_TraineeListFragment)
        }
    }
}