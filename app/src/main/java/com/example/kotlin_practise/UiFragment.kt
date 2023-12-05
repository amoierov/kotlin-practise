package com.example.kotlin_practise

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.adapters.TagAdapter
import com.example.kotlin_practise.databinding.FragmentUiBinding
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class UiFragment : BaseFragment(R.layout.fragment_ui) {
    private val binding by viewBinding(FragmentUiBinding::bind)
    private var tagList = emptyList<String>()
    private fun modelBinding(model: MyModel) {
        tagList = model.tags

        if (model.picture) binding.someImageCard.visibility = View.VISIBLE
        else binding.someImageCard.visibility = View.GONE

        binding.mail.text = model.userName
        binding.textImageCard.text = model.descriptor
        binding.userSignCard.text = model.signature

    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rcView_tags)
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

