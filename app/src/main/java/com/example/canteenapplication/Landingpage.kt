package com.example.canteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentLandingpageBinding

class Landingpage : Fragment() {

    private lateinit var binding: FragmentLandingpageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingpageBinding.inflate(inflater, container, false)

        binding.btAdmin.setOnClickListener {
            findNavController().navigate(LandingpageDirections.actionLandingpageToAdminLoginpage())
        }
        binding.btUser.setOnClickListener {
            findNavController().navigate(LandingpageDirections.actionLandingpageToUserloginpage3())
        }
        return binding.root

    }
}
