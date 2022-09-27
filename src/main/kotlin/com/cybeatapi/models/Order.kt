package com.cybeatapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(val id: Int, val contents: List<OrderItem>)

@Serializable
data class OrderItem(
    val id: Int,
    val item: MenuItem
)

val orderStorage = mutableListOf<Order>(
    Order(
        1, listOf(
            OrderItem(1, MenuItem(1,"Ham Sandwich", Category(3, "Burgers"), 2, 55, 100, 100)),
            OrderItem(2, MenuItem(2,"Water", Category(4, "Drinks"), 1, 15, 250, 100)),
            OrderItem(3, MenuItem(3,"Beer", Category(4, "Drinks"), 3, 23, 200, 350)),
            OrderItem(4, MenuItem(4,"Cheesecake", Category(5, "Sausages"), 1, 37, 150, 252)),
        )
    ),
    Order(
        2, listOf(
            OrderItem(5, MenuItem(5,"Cheeseburger", Category(2, "Pizza"), 1, 85, 230, 501)),
            OrderItem(6, MenuItem(2,"Water", Category(4, "Drinks"), 2, 15, 250, 100)),
            OrderItem(7, MenuItem(6, "Coke", Category(4, "Drinks"), 2, 17, 50, 70)),
            OrderItem(8, MenuItem(7,"Ice Cream", Category(1, "Sushi"), 1, 23, 120, 130)),
        )
    )
)