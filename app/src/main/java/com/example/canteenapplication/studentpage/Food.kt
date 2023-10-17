package com.example.canteenapplication.studentpage

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
        name = "Shanghai Na Tutong"
    ),
    Food(
        id = 3,
        image = R.drawable.logo,
        name = "Shanghai City"
    ),
    Food(
        id = 4,
        image = R.drawable.shanghai_rolled,
        name = "Shanghai Ni Carl"
    ),
    Food(
        id = 5,
        image = R.drawable.logo,
        name = "Shanghai na Pangit"
    ),
    Food(
        id = 6,
        image = R.drawable.logo,
        name = "jjjj"
    ),
    Food(
        id = 7,
        image = R.drawable.logo,
        name = "jj"
    )
)