package com.example.learningfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learningfragment.databinding.ActivityEj01FragmentStaticBinding
import com.example.learningfragment.databinding.ActivityMainBinding

class Ej01StaticFragmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEj01FragmentStaticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj01FragmentStaticBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}