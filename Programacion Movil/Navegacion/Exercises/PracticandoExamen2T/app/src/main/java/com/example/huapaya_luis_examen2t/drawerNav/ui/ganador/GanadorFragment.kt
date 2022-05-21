package com.example.huapaya_luis_examen2t.drawerNav.ui.ganador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.huapaya_luis_examen2t.databinding.FragmentGanadorBinding

class GanadorFragment : Fragment() {

    private var _binding: FragmentGanadorBinding? = null
    private val binding get() = _binding!!
    private val args: GanadorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGanadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.TxtGanador.visibility = View.VISIBLE
        binding.Txtjugador.visibility = View.VISIBLE
        binding.Txtjugador.text = args.jugador
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}