package com.example.kotlin_practise

import TagAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.databinding.FragmentUiBinding
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class UiFragment : BaseFragment() {
    override fun getLayoutRes(): Int = R.layout.fragment_ui
    private val binding by viewBinding(FragmentUiBinding::bind)
    private var tagList = emptyList<String>()
    private fun modelBinding(model: MyModel) {
        tagList = model.tags

        if (model.picture) binding.someImage.visibility = View.VISIBLE
        else binding.someImage.visibility = View.GONE

        binding.mail.text = model.userName
        binding.textImage.text = model.descriptor
        binding.textView2.text = model.signature

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rcView)
        modelBinding(modelInstance2)

        val adapter = TagAdapter(tagList)
        recyclerView.adapter = adapter

        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        recyclerView.layoutManager = layoutManager

        binding.buttonToSecond.setOnClickListener {
            navigateTo(R.id.action_uiFragment_to_secondFragment)
        }

        binding.buttonExit.setOnClickListener {
            showToast()
        }

    }
    private fun showToast() {
        val toast = Toast.makeText(requireContext(), "Button Exit Clicked", Toast.LENGTH_SHORT)
        toast.show()
    }

}

