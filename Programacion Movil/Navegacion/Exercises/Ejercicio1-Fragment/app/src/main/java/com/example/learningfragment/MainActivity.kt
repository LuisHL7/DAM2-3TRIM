package com.example.learningfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButExercise1.setOnClickListener { startActivity(Intent(this,Ej01StaticFragmentsActivity::class.java)) }
        binding.ButExercise2.setOnClickListener { startActivity(Intent(this,Ej02DynamicFragmentsActivity::class.java)) }


    }
}