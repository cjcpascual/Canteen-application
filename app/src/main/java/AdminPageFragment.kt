/*
package com.example.canteenapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.canteenapplication.databinding.FragmentAdminpageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AdminPageFragment : Fragment() {
    private lateinit var binding: FragmentAdminpageBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var userRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminpageBinding.inflate(inflater, container, false)
        val view = binding.root

        val emailEditText = binding.emailEditText
        val creditEditText = binding.creditEditText
        val containerLayout = binding.containerLayout

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        userRef = database.getReference("users")

        binding.viewPurchasesButton.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Find the user by email
               */
/* userRef.orderByChild("emailAddress").equalTo(email).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (userSnapshot in snapshot.children) {
                            val user = userSnapshot.getValue(User::class.java)
                            if (user != null) {
                                // Retrieve and display user purchase history
                                val purchaseHistory = user.purchaseHistory
                                val purchaseText = StringBuilder()
                                for (purchase in purchaseHistory) {
                                    purchaseText.append("Item: ${purchase.Food}, Quantity: ${purchase.quantity}\n")
                                }
                                purchaseHistoryTextView.text = purchaseText.toString()
                            }
                        }
                    } else {
                        Toast.makeText(requireContext(), "User not found.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), "Failed to fetch data.", Toast.LENGTH_SHORT).show()
                }
            })*//*


            // Add com.example.canteenapplication.StudentPage.Credit Functionality
            val addCreditButton = Button(requireContext())
            addCreditButton.text = "Add com.example.canteenapplication.StudentPage.Credit"
            addCreditButton.setOnClickListener {
                // Display an AlertDialog to input the credit amount to add
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Add com.example.canteenapplication.StudentPage.Credit")

                val input = EditText(requireContext())
                input.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
                builder.setView(input)

                builder.setPositiveButton("OK") { _, _ ->
                    val creditToAdd = input.text.toString().toDoubleOrNull()
                    if (creditToAdd != null) {
                        // Update the user's credit balance in Firebase
                        val user = FirebaseAuth.getInstance().currentUser
                        if (user != null) {
                            val uid = user.uid
                            val userRef = database.getReference("users").child(uid)

                            userRef.child("credit").get().addOnSuccessListener { dataSnapshot ->
                                val currentCredit = dataSnapshot.getValue(Double::class.java) ?: 0.0
                                val newCredit = currentCredit + creditToAdd
                                userRef.child("credit").setValue(newCredit)
                            }.addOnFailureListener {
                                Toast.makeText(
                                    requireContext(),
                                    "Failed to update credit",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Invalid credit amount",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                builder.setNegativeButton("Cancel") { dialog, _ ->
                    dialog.cancel()
                }

                builder.show()
            }

            // Add the "Add com.example.canteenapplication.StudentPage.Credit" button to the layout
            containerLayout.removeAllViews()
            containerLayout.addView(addCreditButton)
        }

        return view
    }
}*/
