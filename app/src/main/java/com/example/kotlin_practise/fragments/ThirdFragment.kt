package com.example.kotlin_practise.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment(R.layout.fragment_third) {
    private val binding by viewBinding(FragmentThirdBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToUiFragment.setOnClickListener {
            navigateTo(R.id.action_thirdFragment_to_cardListFragment)
        }
    }
}