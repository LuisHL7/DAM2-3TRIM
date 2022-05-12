package com.example.learningfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.learningfragment.databinding.ActivityEj02DynamicFragmentsBinding


class Ej02DynamicFragmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEj02DynamicFragmentsBinding
    lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj02DynamicFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val redFragment = RedFragment.newInstance()
        val blueFragment = BlueFragment()

        fragment = redFragment
        
        binding.BtnCambiar.setOnClickListener { fragment = if(fragment == redFragment) blueFragment else redFragment }


    }
}