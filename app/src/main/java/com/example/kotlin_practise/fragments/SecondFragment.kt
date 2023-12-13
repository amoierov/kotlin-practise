package com.example.kotlin_practise.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.FragmentSecondBinding


class SecondFragment : BaseFragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToThird.setOnClickListener {
            navigateTo(R.id.action_secondFragment_to_thirdFragment)
        }
    }
}