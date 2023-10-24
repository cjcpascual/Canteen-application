package com.example.canteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentLandingPageBinding

class LandingPageFragment : Fragment() {

    private lateinit var binding: FragmentLandingPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingPageBinding.inflate(inflater, container, false)

/*        binding.btAdmin.setOnClickListener {
            findNavController().navigate(LandingPageFragmentDirections.actionLandingPageToAdminLoginPage())
        }*/

        binding.btUser.setOnClickListener {
            findNavController().navigate(LandingPageFragmentDirections.actionLandingPageToUserLoginPage3())
        }
        return binding.root

    }
}
