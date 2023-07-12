package com.example.quizLianyRahman2010071

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quizLianyRahman2010071.Util.Pref
import com.example.quizLianyRahman2010071.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {
            if (it.itemId == R.id.navigation_notifications) {
                val s = Pref(this)
                if (s.getISlogin()) {
                    Log.d("TAG", "SUDAH LOGIN")
                } else {
                    //startActivity(Intent(this,LoginActivity::class.java))
                    startActivity(Intent(this, activity_login::class.java))
                    Log.d("TAG", "Belum Login pindah ke hal login")
                }

            } else {
                Log.d("TAG", "onCreate yg Lain" + it.itemId)
                navController.navigate(it.itemId)
            }
            return@setOnItemSelectedListener true
        }
    }

}