package com.example.canteenapplication.studentpage

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.canteenapplication.databinding.ItemBinding

class FoodAdapter(
    private val quantityListener: (Food, Int) -> Unit
) : ListAdapter<Food, FoodAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        quantityListener
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemBinding,
        private val quantityListener: (Food, Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var item: Food? = null

        init {
            binding.quantity.setListener { quantity ->
                item?.let { quantityListener.invoke(it, quantity) }
            }
        }

        fun onBind(item: Food) {
            this.item = item
            binding.quantity.quantity = item.quantity
            binding.image.setImageResource(item.image)
            binding.item.text = item.name
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Food>() {

        override fun areItemsTheSame(
            oldItem: Food,
            newItem: Food
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Food,
            newItem: Food
        ): Boolean = oldItem.name == newItem.name &&
                oldItem.image == newItem.image &&
                oldItem.quantity == newItem.quantity
    }
}
