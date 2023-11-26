package com.example.kotlin_practise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kotlin_practise.UiFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // Переопределение обработки кнопки "назад"
        if (navController.currentDestination?.id != R.id.uiFragment) {
            // Если текущий фрагмент - третий, то навигация к главному фрагменту
            navController.navigate(R.id.uiFragment)
        } else {
            // В противном случае, стандартное поведение для кнопки "назад"
            super.onBackPressed()
        }
    }
}


