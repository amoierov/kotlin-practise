package com.example.kotlin_practise.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin_practise.R
import com.example.kotlin_practise.databinding.FragmentThreadBinding
import kotlin.random.Random

class ThreadFragment : BaseFragment(R.layout.fragment_thread) {

    private val binding by viewBinding(FragmentThreadBinding::bind)
    private var isRunning = false
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var resultTextView: TextView
    private lateinit var startStopButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultTextView = binding.outputTextView
        startStopButton = binding.buttonStart
        startStopButton.setOnClickListener {
            if (isRunning) {
                stopAction()
            } else {
                startAction()
            }
        }
    }
    private fun stopAction() {
        isRunning = false
        startStopButton.text = "Старт"
    }

    private fun startAction() {
        isRunning = true
        startStopButton.text = "Стоп"

        Thread {
            while (isRunning) {
                handler.post {
                    if (Random.nextBoolean()) {
                        resultTextView.text = Random.nextInt(100).toString()
                    } else {
                        resultTextView.text = "Строка строка строка"
                    }
                }
                Thread.sleep(2000)
            }
        }.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        isRunning = false
    }
}