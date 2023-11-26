package com.example.kotlin_practise

import TagAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practise.databinding.FragmentUiBinding
import com.example.kotlin_practise.databinding.TagItemBinding
import com.example.kotlin_practise.models.MyModel
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap



class UiFragment : Fragment() {
    private lateinit var binding: FragmentUiBinding

    private var tagList = emptyList<String>()
    private fun modelBinding(model: MyModel) {
        tagList = model.tags
        if (model.picture) {
            binding.someImage.visibility = View.VISIBLE
        } else binding.someImage.visibility = View.GONE
        binding.mail.text = model.userName
        binding.textImage.text = model.descriptor
        binding.textView2.text = model.signature

    }


    private val modelInstance1 = MyModel("adele@gmail.com", false, "Hello, it's me\n" +
            "I was wondering if after all these years you'd like to meet\n" +
            "To go over everything\n" +
            "They say that time's supposed to heal ya, but i ain't done much healing", "Adele's GRAMMY History", listOf("Easy on Me",
            "Skyfall", "Hello", "When We Were Young", "Remedy", "Send My Love(To Your New Lover)", "Rolling in the Deep")
    )

    private val modelInstance2 = MyModel("cortisol@body.com", true, "An ancient discipline, Yoga is a concept that comes from a Sanskrit word\n " +
            "meaning 'union'. It combines bodily processes with breathing techniques, meditation, and mental\n" +
            "exercises in order to bring a sense of calm and composure in life", "Yoga has the ability to reduce stress by diminishing mental discomfort", listOf("Ashtanga",
            "Iyengar", "Bikram", "Yin", "Kundalini")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUiBinding.inflate(inflater, container, false)
        val navController = findNavController()
        val buttonToSecond = binding.buttonToSecond
        buttonToSecond.setOnClickListener {
            navController.navigate(R.id.action_uiFragment_to_secondFragment)
        }
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUiBinding.bind(view)


        val recyclerView: RecyclerView = view.findViewById(R.id.rcView)

        modelBinding(modelInstance2)

        val adapter = TagAdapter(tagList)
        recyclerView.adapter = adapter

        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        recyclerView.layoutManager = layoutManager

        binding.buttonExit.setOnClickListener {
            // Отображение Toast при нажатии на кнопку
            showToast()
        }

    }

    private fun showToast() {
        val toast = Toast.makeText(requireContext(), "Button Exit Clicked", Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }


    companion object {
        @JvmStatic
        fun newInstance() = UiFragment()
    }
}