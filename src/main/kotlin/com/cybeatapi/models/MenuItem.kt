package com.cybeatapi.models

import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val item: String,
    val category: Category,
    val amount: Int,
    var price: Int,
    val weight: Int,
    val calories: Int,
    val image: String = ""
)

val menuStorage = mutableListOf<MenuItem>(
    MenuItem(1, "Ham Sandwich", Category(3, "Burgers"), 2, 55, 100, 100),
    MenuItem(2, "Water", Category(4, "Drinks"), 1, 15, 250, 100),
    MenuItem(3, "Beer", Category(4, "Drinks"), 3, 23, 200, 350),
    MenuItem(4, "Cheesecake", Category(5, "Sausages"), 1, 37, 150, 252),
    MenuItem(5, "Cheeseburger", Category(2, "Pizza"), 1, 85, 230, 501),
    MenuItem(6, "Coke", Category(4, "Drinks"), 2, 17, 50, 70),
    MenuItem(7, "Ice Cream", Category(1, "Sushi"), 1, 23, 120, 130),
)