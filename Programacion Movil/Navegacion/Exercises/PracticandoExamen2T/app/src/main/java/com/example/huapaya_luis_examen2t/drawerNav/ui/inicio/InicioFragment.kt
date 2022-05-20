package com.example.huapaya_luis_examen2t.drawerNav.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import com.example.huapaya_luis_examen2t.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.BtnEmpezar.setOnClickListener {
            Navigation.findNavController(view).navigate(InicioFragmentDirections.actionNavInicioToNavTresenraya())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}