package com.example.canteenapplication.StudentPage

import androidx.annotation.DrawableRes
import com.example.canteenapplication.R

data class Food(
    val id: Long,
    @DrawableRes val image: Int,
    val name: String,
    val quantity: Int = 0
)

val foods = listOf(
    Food(
        id = 1,
        image = R.drawable.logo,
        name = "Shanghai"
    ),
    Food(
        id = 2,
        image = R.drawable.shanghai_rolled,
        name = "Siomai"
    ),
    Food(
        id = 3,
        image = R.drawable.logo,
        name = "Donut"
    ),
    Food(
        id = 4,
        image = R.drawable.shanghai_rolled,
        name = "Palabok"
    ),
    Food(
        id = 5,
        image = R.drawable.logo,
        name = "Pansit"
    ),
    Food(
        id = 6,
        image = R.drawable.logo,
        name = "Dynamite"
    ),
    Food(
        id = 7,
        image = R.drawable.logo,
        name = "Turon"
    )
)