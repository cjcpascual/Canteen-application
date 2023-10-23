package com.example.canteenapplication

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentUserLoginPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.FirebaseDatabase


class UserLoginPageFragment : Fragment() {

    private lateinit var binding: FragmentUserLoginPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserLoginPageBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.userLoginButton.setOnClickListener {
            val userEmailAddress = binding.userEmailAddressEditText.text.toString()
            val userPassword = binding.userPasswordEditText.text.toString()

            if (userEmailAddress.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Invalid  email and password",Toast.LENGTH_SHORT).show()
            } else {
                signInWithFirebase(userEmailAddress, userPassword)
            }


        }
        binding.userRegistrationButton.setOnClickListener {
            findNavController().navigate(UserLoginPageFragmentDirections.actionUserLoginPageToUserRegistrationPageFragment())
        }
        return view
    }

    private fun signInWithFirebase(userEmailAddress: String, userPassword: String) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(userEmailAddress, userPassword)
            .addOnCompleteListener(requireActivity()){ task ->
                if(task.isSuccessful){
                    Toast.makeText(context, "Login Successful",Toast.LENGTH_SHORT).show()
                    findNavController().navigate(UserLoginPageFragmentDirections.actionUserLoginPageToStudentPage())
                } else {
                    Toast.makeText(requireContext(),"Login Failed. Check your Email and Password", Toast.LENGTH_SHORT).show()
                    binding.userEmailAddressEditText.text?.clear()
                    binding.userPasswordEditText.text?.clear()
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




