package com.example.kotlin_practise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import androidx.viewbinding.ViewBinding

abstract class BaseFragment: Fragment() {
    abstract fun getLayoutRes(): Int

    protected fun navigateTo(destinationId: Int) {
        findNavController().navigate(destinationId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }
}

