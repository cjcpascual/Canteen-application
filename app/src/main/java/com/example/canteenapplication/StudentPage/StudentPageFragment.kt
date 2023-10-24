package com.example.canteenapplication.StudentPage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog  // Import AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.canteenapplication.R
import com.example.canteenapplication.databinding.FragmentStudentPageBinding

class StudentPageFragment : Fragment() {
    private lateinit var adapter: FoodAdapter
    private var binding: FragmentStudentPageBinding? = null

    private var items = foods
    private var creditAmount = 0.00  // Initial credit amount

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentStudentPageBinding.inflate(inflater, container, false).run {
            binding = this
            root
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FoodAdapter { food, quantity ->
            items = items.map {
                if (food.id == it.id) {
                    it.copy(quantity = quantity)
                } else it
            }
            adapter.submitList(items)
        }
        with(requireNotNull(binding)) {
            rvFoods.adapter = adapter
            adapter.submitList(foods)


            val creditAmountTextView: TextView = root.findViewById(R.id.creditAmountTextView)
            val addCreditButton: Button = root.findViewById(R.id.addCreditButton)
            val openCartButton: Button = root.findViewById(R.id.openCartButton)
            val cartLayout: FrameLayout = root.findViewById(R.id.cartLayout)
            val clearCartButton: Button = root.findViewById(R.id.clearCartButton)
            val cartItemListLayout: LinearLayout = root.findViewById(R.id.cartItemListLayout)
            val buyItemsButton: Button = root.findViewById(R.id.buyItemsButton)

            clearCartButton.setOnClickListener{
                items = items.map { it.copy(quantity = 0) }
                cartItemListLayout.removeAllViews()
                adapter.submitList(items)

                // Hide the cart layout
                cartLayout.visibility = View.VISIBLE
                // Hide the "Clear Cart" button
                clearCartButton.visibility = View.VISIBLE


                // Show a confirmation message
                Toast.makeText(
                    requireContext(),
                    "Items Cleared.",
                    Toast.LENGTH_SHORT
                ).show()


            }

            // Set the initial credit amount in the TextView
            creditAmountTextView.text = "Credit Amount: $creditAmount"

            addCreditButton.setOnClickListener {
                // Use an AlertDialog to display a pop-up for adding credit
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Add Credit")

                val input = EditText(requireContext())
                input.inputType =
                    android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
                builder.setView(input)

                builder.setPositiveButton("OK") { _, _ ->
                    val creditToAdd = input.text.toString().toDoubleOrNull()
                    if (creditToAdd != null) {
                        // Add the entered credits to the total
                        creditAmount += creditToAdd

                        // Update the TextView with the new credit amount
                        creditAmountTextView.text = "Credit Amount: $creditAmount"

                        Toast.makeText(
                            requireContext(),
                            "Added $creditToAdd credits.",
                            Toast.LENGTH_SHORT
                        ).show()
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

            openCartButton.setOnClickListener {
                // Populate the cart item list (to be adapted to your data)
                cartItemListLayout.removeAllViews()
                val cartItems = items.filter { it.quantity > 0 }
                for (item in cartItems) {
                    val itemTextView = TextView(requireContext())
                    itemTextView.text = "${item.name} (${item.quantity}x)"
                    cartItemListLayout.addView(itemTextView)
                }

                // Show the cart layout
                cartLayout.visibility = View.VISIBLE

                addCreditButton.visibility = View.GONE
                openCartButton.visibility = View.GONE
            }

            val closeCartButton: Button = root.findViewById(R.id.closeCartButton)
            val navController = findNavController()

            closeCartButton.setOnClickListener {
                // Hide the cart layout
                cartLayout.visibility = View.GONE

                addCreditButton.visibility = View.VISIBLE
                openCartButton.visibility = View.VISIBLE

            }

             fun calculateTotalPrice(cartItems: List<Food>): Double {
                var totalPrice = 0.0
                for (item in cartItems) {
                    totalPrice += item.price * item.quantity
                }
                return totalPrice
            }

            buyItemsButton.setOnClickListener {
                val cartItems = items.filter { it.quantity > 0 }
                val totalPrice = calculateTotalPrice(cartItems)

                if (totalPrice <= creditAmount) {
                    // Deduct the total price from the user's credit
                    creditAmount -= totalPrice

                    // Update the TextView with the new credit amount
                    creditAmountTextView.text = "Credit Amount: $creditAmount"

                    // Clear the cart by setting the quantity of all items to 0
                    items = items.map { it.copy(quantity = 0) }
                    adapter.submitList(items)

                    // Hide the cart layout
                    cartLayout.visibility = View.GONE
                    addCreditButton.visibility = View.VISIBLE
                    clearCartButton.visibility = View.VISIBLE
                    openCartButton.visibility = View.VISIBLE

                    // Show a confirmation message with the total price
                    Toast.makeText(
                        requireContext(),
                        "Items purchased successfully. Total cost: $totalPrice",
                        Toast.LENGTH_SHORT
                    ).show()
                    cartItemListLayout.removeAllViews()
                    cartLayout.visibility = View.VISIBLE
                    addCreditButton.visibility = View.GONE
                    openCartButton.visibility = View.GONE
                } else {
                    // Show an error message if the user does not have enough credit
                    Toast.makeText(
                        requireContext(),
                        "Insufficient credit to purchase items. Total cost: $totalPrice",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        // Check if the cart is open, if so, close it; otherwise, navigate back to the login page.
                        if (cartLayout.visibility == View.VISIBLE) {
                            cartLayout.visibility = View.GONE
                        } else {
                            // Navigate back to the login page
                            navController.popBackStack(R.id.userLoginPage, false)
                        }
                    }


                })


        }


    }
}