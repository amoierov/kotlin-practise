package com.example.kotlin_practise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.databinding.FragmentSecondBinding
import com.example.kotlin_practise.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment() {
    override fun getLayoutRes(): Int = R.layout.fragment_third
    private val binding by viewBinding(FragmentThirdBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonToUiFragment.setOnClickListener {
            navigateTo(R.id.action_thirdFragment_to_cardListFragment)
        }
    }
}