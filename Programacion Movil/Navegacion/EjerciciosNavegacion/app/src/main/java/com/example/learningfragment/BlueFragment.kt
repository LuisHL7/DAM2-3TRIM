package com.example.learningfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.learningfragment.databinding.FragmentBlueBinding

class BlueFragment : Fragment() {

    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout porque está en null
        _binding = FragmentBlueBinding.inflate(inflater, container, false)

        //Ahora que la propiedad binding ya no es null la utilizamos.
        binding.BtnBlue.setOnClickListener {
            Toast.makeText(activity, "Click en azul", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /* Los fragments duran más que sus views, por eso deben limpiarse las referencias a su binding class
        * Es también por esto por lo que no se deben declarar como lateinit. Ya que esto llevaría a no poder
        * reasignarlos a null cuando la vista se destruye, llevando a fugas de memoria (memory leaks)
        * https://stackoverflow.com/questions/70065804/why-not-use-lateinit-modifier-in-andrioid-fragment-data-binding */

}