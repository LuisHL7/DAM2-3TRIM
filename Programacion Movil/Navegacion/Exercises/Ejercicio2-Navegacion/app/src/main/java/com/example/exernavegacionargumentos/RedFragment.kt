package com.example.exernavegacionargumentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.exernavegacionargumentos.databinding.FragmentRedBinding

class RedFragment : Fragment() {

    private var _binding: FragmentRedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRedBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        /** Recibimos el argumento recibido desde el otro fragmento y lo mostramos */
        Toast.makeText(activity, RedFragmentArgs.fromBundle(requireArguments()).argumentToRed.toString(),
            Toast.LENGTH_SHORT).show()

        /** Recibimos el argumento recibido desde el otro fragmente y lo mostramos */
//        val argumentoRecibido = RedFragmentArgs.fromBundle(requireArguments()).argumentToRed
//        Toast.makeText(activity, "$argumentoRecibido", Toast.LENGTH_SHORT).show()
        binding.BtnCambiar.setOnClickListener {
            navController.navigate(RedFragmentDirections.actionRedFragmentToBlueFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}