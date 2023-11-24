package com.example.kotlin_practise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_practise.UiFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, UiFragment.newInstance())
            .commit()
    }
}

