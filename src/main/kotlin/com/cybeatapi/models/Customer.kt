package com.cybeatapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String
)

val customerStorage = mutableListOf<Customer>()
