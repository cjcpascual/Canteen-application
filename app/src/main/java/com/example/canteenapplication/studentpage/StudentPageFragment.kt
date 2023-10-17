package com.example.canteenapplication.studentpage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.canteenapplication.R
import com.example.canteenapplication.databinding.FragmentStudentPageBinding

class StudentPageFragment : Fragment() {
    private lateinit var adapter: FoodAdapter
    private var binding: FragmentStudentPageBinding? = null

    private var items = foods
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentStudentPageBinding.inflate(inflater, container, false).run {
            binding = this
            root
        }
    }

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

            fabAddToCart.setOnClickListener {
                val addedItems = items.filter { it.quantity > 0 }

                // TODO remove, add action for add to cart
                Toast.makeText(
                    requireContext(),
                    "Added items: \n" + addedItems.joinToString {
                        "${it.quantity} ${it.name}"
                    }, Toast.LENGTH_SHORT
                ).show()

                // reset items
                items = items.map {
                    it.copy(quantity = 0)
                }
                adapter.submitList(items)
            }
        }
    }
}
