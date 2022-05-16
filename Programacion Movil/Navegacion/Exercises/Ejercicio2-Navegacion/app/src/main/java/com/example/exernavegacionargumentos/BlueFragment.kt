package com.example.exernavegacionargumentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.exernavegacionargumentos.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {
    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        binding.BtnEnviar.setOnClickListener {
            binding.EdtNumber.text.toString().toIntOrNull()?.let {
                val action = BlueFragmentDirections.actionBlueFragmentToRedFragment(it)
                navController.navigate(action)
            }?: Toast.makeText(activity,"Debe introducir un número",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}