package com.example.canteenapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentUserloginpageBinding


class Userloginpage : Fragment() {

    private lateinit var binding: FragmentUserloginpageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserloginpageBinding.inflate(inflater,container,false)

        binding.btLogin.setOnClickListener {
            findNavController().navigate(UserloginpageDirections.actionUserloginpage3ToStudentpage())
        }

        binding.tvRegistration.setOnClickListener {
            findNavController().navigate(UserloginpageDirections.actionUserloginpage3ToRegistrationpage())

        }
        binding.btLogin.setOnClickListener{
            findNavController().navigate(UserloginpageDirections.actionUserloginpage3ToStudentpage())
        }
        //inflate the layout for this fragment
        return binding.root
    }
}



