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
import com.example.kotlin_practise.databinding.FragmentUiBinding
import com.example.kotlin_practise.models.MyModel
import com.example.kotlin_practise.models.modelInstance2
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class UiFragment : Fragment() {
    private var _binding: FragmentUiBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private var tagList = emptyList<String>()
    private fun modelBinding(model: MyModel) {
        tagList = model.tags

        if (model.picture) binding.someImage.visibility = View.VISIBLE
        else binding.someImage.visibility = View.GONE

        binding.mail.text = model.userName
        binding.textImage.text = model.descriptor
        binding.textView2.text = model.signature

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUiBinding.inflate(inflater, container, false)
        val navController = findNavController()
        val buttonToSecond = binding.buttonToSecond
        buttonToSecond.setOnClickListener {
            navController.navigate(R.id.action_uiFragment_to_secondFragment)
        }
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUiBinding.bind(view)


        val recyclerView: RecyclerView = view.findViewById(R.id.rcView)

        modelBinding(modelInstance2)

        val adapter = TagAdapter(tagList)
        recyclerView.adapter = adapter

        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        recyclerView.layoutManager = layoutManager

        binding.buttonExit.setOnClickListener {
            showToast()
        }

    }

    private fun showToast() {
        val toast = Toast.makeText(requireContext(), "Button Exit Clicked", Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}