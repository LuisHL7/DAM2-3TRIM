package com.example.huapaya_luis_examen2t

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.huapaya_luis_examen2t.bottomNav.BottonNavigation
import com.example.huapaya_luis_examen2t.databinding.ActivityMainBinding
import com.example.huapaya_luis_examen2t.drawerNav.NavigationDrawerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnBottomNav.setOnClickListener {
            startActivity(Intent(this, BottonNavigation::class.java))
        }
        binding.BtnDrawerNav.setOnClickListener {
            startActivity(Intent(this, NavigationDrawerActivity::class.java))
        }
    }
}