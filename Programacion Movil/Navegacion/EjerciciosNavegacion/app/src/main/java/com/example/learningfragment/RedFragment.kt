package com.example.learningfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.learningfragment.databinding.FragmentRedBinding


class RedFragment : Fragment() {
    private var _binding: FragmentRedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRedBinding.inflate(inflater,container,false)

        binding.BtnRed.setOnClickListener {
            Toast.makeText(activity, "Click en rojo", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment RedFragment.
         */
        @JvmStatic
        fun newInstance() = RedFragment()
    }
}