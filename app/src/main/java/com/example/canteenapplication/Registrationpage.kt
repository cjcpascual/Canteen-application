package com.example.canteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentRegistrationpageBinding


class Registrationpage : Fragment() {

    private lateinit var binding: FragmentRegistrationpageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationpageBinding.inflate(inflater, container, false)

        binding.btSubmit.setOnClickListener {
            findNavController().navigate(RegistrationpageDirections.actionRegistrationpageToUserloginpage3())
        }
        binding.btSubmit.setOnClickListener {
            findNavController().navigate(RegistrationpageDirections.actionRegistrationpageToUserloginpage3())
        }
        return binding.root

    }
}
