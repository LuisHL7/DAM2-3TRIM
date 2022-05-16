package com.example.exernavegacionargumentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.exernavegacionargumentos.RedFragmentDirections.Companion.actionRedFragmentToBlueFragment
import com.example.exernavegacionargumentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        /* Para recuperar el navControler de un NavHostFragment(FragmentContainerView) desde la activity que lo contiene: */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

                binding.BtnCambiar.setOnClickListener {
            when(navController.currentDestination?.id){
                R.id.blueFragment -> navController.navigate(BlueFragmentDirections.actionBlueFragmentToRedFragment())
                R.id.redFragment -> navController.navigate(RedFragmentDirections.actionRedFragmentToBlueFragment())
                else -> throw Exception("No hay acción definida desde el fragment actual")
            }
        }


//      Sin safeargs:
//        binding.BtnCambiar.setOnClickListener {
//            when(navController.currentDestination?.id){
//                R.id.blueFragment -> navController.navigate(R.id.action_blueFragment_to_redFragment)
//                R.id.redFragment -> navController.navigate(R.id.action_redFragment_to_blueFragment)
//                else -> throw Exception("No hay acción definida desde el fragment actual")
//            }
//
//        }



    }
}