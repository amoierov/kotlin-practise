package com.example.kotlin_practise.fragments
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {


    protected fun navigateTo(destinationId: Int) {
        findNavController().navigate(destinationId)
    }
}

