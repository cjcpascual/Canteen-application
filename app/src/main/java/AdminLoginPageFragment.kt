/*
package com.example.canteenapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentAdminLoginPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase


class AdminLoginPageFragment : Fragment() {

    private lateinit var binding: FragmentAdminLoginPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminLoginPageBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.loginButton.setOnClickListener {
            val emailAddress = binding.emailAddressEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (emailAddress.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Invalid  email and password",Toast.LENGTH_SHORT).show()
            } else {
                signInWithFirebase(emailAddress, password)
            }


        }
        binding.registrationButton.setOnClickListener {
            findNavController().navigate(AdminLoginPageFragmentDirections.actionAdminLoginPageToAdminRegistrationPageFragment())
        }
        return view
    }

    private fun signInWithFirebase(emailAddress: String, password: String) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(emailAddress, password)
            .addOnCompleteListener(requireActivity()){ task ->
                if(task.isSuccessful){
                    Toast.makeText(context, "Login Successful",Toast.LENGTH_SHORT).show()
                    findNavController().navigate(AdminLoginPageFragmentDirections.actionAdminLoginPageToAdminPage())
                } else {
                    Toast.makeText(requireContext(),"Login Failed. Check your Email and Password", Toast.LENGTH_SHORT).show()
                    binding.emailAddressEditText.text?.clear()
                    binding.passwordEditText.text?.clear()
                }
            }
    }



    private fun showSuccessDialog() {
        val context = requireContext()
        val builder = AlertDialog.Builder(context)
        val view = LayoutInflater.from(context).inflate(R.layout.successlogin_dialog, null)
        builder.setView(view)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun showFailureDialog() {
        val context = requireContext()
        val builder = AlertDialog.Builder(context)
        val view = LayoutInflater.from(context).inflate(R.layout.failure_dialog, null)
        builder.setView(view)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }

}




*/
