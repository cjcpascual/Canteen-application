package com.example.canteenapplication.Registrations


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.databinding.FragmentUserRegistrationPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class UserRegistrationPageFragment : Fragment() {

    private lateinit var binding: FragmentUserRegistrationPageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentUserRegistrationPageBinding.inflate(inflater, container, false)
        val view = binding.root



        binding.submitButton.setOnClickListener {
            val emailAddress = binding.emailAddressEditText.text.toString()
            val password = binding.passwordEditText.text.toString()


            if (emailAddress.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Invalid", Toast.LENGTH_SHORT).show()
            } else {
                signUpWithFirebase(emailAddress, password)
            }


        }

        return view
    }

    private fun signUpWithFirebase(emailAddress: String, password: String) {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference.child("users")
        auth.createUserWithEmailAndPassword(emailAddress, password)


            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //Registration successful
                    val user = auth.currentUser
                    val userId = user?.uid

                    //Stores user information
                    val userMap = HashMap<String, Any>()
                    userMap["emailAddress"] = emailAddress
                    userMap["Password"] = password
                    userMap["credit"] = 0.00

                    databaseReference.child(userId ?: "").setValue(userMap)
                    Toast.makeText(context, "Registered Successful", Toast.LENGTH_SHORT).show()

                    findNavController().navigate(UserRegistrationPageFragmentDirections.actionRegistrationPageToUserLoginPage())


                } else {
                    // Handle login failure
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthInvalidUserException) {
                        // Handle non-existent user
                        Toast.makeText(context, "Invalid Email Address", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthWeakPasswordException) {
                        // Handle weak password
                        Toast.makeText(context, "Weak Password", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthUserCollisionException) {
                        // Handle email already in use
                        Toast.makeText(context, "Email Already in use", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        // Handle invalid credentials
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        // Handle other exceptions
                    }
                }
            }
    }
}








