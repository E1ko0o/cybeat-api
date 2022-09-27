package com.cybeatapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val name: String
)

val categoryStorage = mutableListOf<Category>(
    Category(1, "Sushi"),
    Category(2, "Pizza"),
    Category(3, "Burgers"),
    Category(4, "Drinks"),
    Category(5, "Sausages"),
)