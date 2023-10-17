package com.example.canteenapplication

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import com.example.canteenapplication.databinding.ViewQuantityPickerBinding
import kotlin.properties.Delegates

class QuantityPickerView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attributeSet, defStyle) {

    private val binding: ViewQuantityPickerBinding by lazy {
        ViewQuantityPickerBinding.inflate(
            context.getSystemService()!!,
            this,
            true
        )
    }

    private var callback: ((Int) -> Unit)? = null

    var quantity by Delegates.observable(MIN_VALUE) { _, _, newValue ->
        binding.btnQuantityDecrement.isEnabled = newValue > MIN_VALUE
        binding.btnQuantityIncrement.isEnabled = newValue < MAX_VALUE
        binding.txtQuantity.text = newValue.toString()
        callback?.invoke(newValue)
    }

    init {
        quantity = 0
        binding.btnQuantityDecrement.setOnClickListener { quantity -= 1 }
        binding.btnQuantityIncrement.setOnClickListener { quantity += 1 }
    }

    fun setListener(callback: (Int) -> Unit) {
        this.callback = callback
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 99
    }
}
