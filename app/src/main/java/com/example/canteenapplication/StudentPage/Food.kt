package com.example.canteenapplication.StudentPage


data class Food(
    val id: Long,
    val name: String,
    val quantity: Int = 0,
    val imageUrl: String,
    val price: Double = 0.00
)

val foods = listOf(
    Food(
        id = 1,
        name = "Shanghai",
        imageUrl = "https://omnivorescookbook.com/wp-content/uploads/2020/12/201113_Lumpia-Shanghai_550.jpg",
        price = 4.99
    ),
    Food(
        id = 2,
        name = "Siomai",
        imageUrl = "https://tastebudsschoolblog.files.wordpress.com/2020/03/img_20200319_013029-1.jpg?w=719",
        price = 4.99
    ),
    Food(
        id = 3,
        name = "Donut",
        imageUrl = "https://cdn.britannica.com/38/230838-050-D0173E79/doughnuts-donuts.jpg",
        price = 24.99

    ),
    Food(
        id = 4,
        name = "Palabok",
        imageUrl = "https://www.foxyfolksy.com/wp-content/uploads/2021/04/palabok-300t-300x270.jpg",
        price = 39.99
    ),
    Food(
        id = 5,
        name = "Pancit",
        imageUrl = "https://thedelicious.recipes/wp-content/uploads/2023/06/pancit-bihon.jpg",
        price = 39.99
    ),
    Food(
        id = 6,
        name = "Dynamite",
        imageUrl = "https://images.food52.com/q0nknpYQytrZGmTaV2d0j6aBrLY=/1200x900/43ccf1e6-8b90-48e9-a4d8-11962c90d280--dynamite-lumpia.jpg",
        price = 4.99
    ),
    Food(
        id = 7,
        name = "Turon",
        imageUrl = "https://themayakitchen.com/wp-content/uploads/2019/10/TURON.jpg",
        price = 9.99
    )
)