package com.example.learningfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
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

        binding.BtnCambiar.setOnClickListener { fragment = if(fragment == redFragment) blueFragment else redFragment

//            Método tradicional de cambiar un fragment.
//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
//            Añadiendo la dependecia : implementation "androidx.fragment:fragment-ktx:1.4.1"
        supportFragmentManager.commit{addToBackStack(null)
            replace(R.id.fragmentContainerView, fragment)}
        }


    }
}