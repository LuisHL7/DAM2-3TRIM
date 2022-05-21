package com.example.huapaya_luis_examen2t.drawerNav.ui.tresenraya

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.huapaya_luis_examen2t.databinding.FragmentTresenrayaBinding

class TresEnRayaFragment : Fragment() {

    private var _binding: FragmentTresenrayaBinding? = null
    private val binding get() = _binding!!
    private val TAG = TresEnRayaFragment::class.java.name
    private lateinit var modelo: Tablero

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTresenrayaBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGrid.setOnClickListener(::onCellClicked) // Asignamos comportamiento a los botones
        modelo = Tablero() // Instanciamos el modelo en el momento en que se lanza la activity

        binding.BtnReiniciar.setOnClickListener { reset() }

    }


    /** Método que se lanza cuando se hace click en una celda */
    private fun onCellClicked(button: Button) {
        val tag = button.tag.toString().toCharArray()
        val row = tag[0].digitToInt()
        val col = tag[1].digitToInt()
        val jugadorQueMovio = modelo.marcar(row, col) ?: return // TODO: arreglar con scoped functions?

        Log.i(TAG, "Celda [$row,$col] marcada por Jugador $jugadorQueMovio")
        binding.BtnReiniciar.visibility = View.VISIBLE

        button.text = jugadorQueMovio.toString()

        if (modelo.ganador != null) { // Comprobamos si el movimiento ha generado un ganador
            findNavController().navigate(TresEnRayaFragmentDirections.actionNavTresenrayaToNavGanador(jugadorQueMovio.toString()))
        }

    }

    /** Función de extensión que recibe como parámetro una lambda
     * Se exitende GridLayout para que tenga este método, el cual recorre todos los
     * Button que la componen (asunción) y para cada uno de ellos le asigna la función
     * pasada a su OnClickListener */
    private fun GridLayout.setOnClickListener( onClick: (Button) -> Unit ) {
        for (i in 0 until childCount) {
            val boton = getChildAt(i) as Button
            boton.setOnClickListener {
                onClick(boton)
            }
        }
    }

    private fun reset() {
        modelo.reiniciar()
        for (i in 0 until binding.buttonGrid.childCount) {
            (binding.buttonGrid.getChildAt(i) as Button).text = null
        }
        binding.BtnReiniciar.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


