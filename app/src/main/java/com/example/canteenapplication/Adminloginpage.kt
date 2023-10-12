package com.example.canteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentAdminloginpageBinding

class AdminLoginpage : Fragment() {

    private lateinit var binding: FragmentAdminloginpageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminloginpageBinding.inflate(inflater,container,false)


        binding.btLogin.setOnClickListener{
            findNavController().navigate(AdminLoginpageDirections.actionAdminLoginpageToAdminpage())
        }
        binding.tvRegistration.setOnClickListener{
            findNavController().navigate(AdminLoginpageDirections.actionAdminLoginpageToRegistrationpage())
        }
        binding.btLogin.setOnClickListener {
            findNavController().navigate(AdminLoginpageDirections.actionAdminLoginpageToAdminpage())
        }
        return binding.root
    }

}
