package com.cybeatapi.dao.dish

import com.cybeatapi.models.Dish

interface DAOFacadeDish {
    suspend fun getAll(): List<Dish>
    suspend fun getById(id: Int): Dish?
    suspend fun add(dish: Dish): Dish?
    suspend fun edit(dish: Dish): Boolean
    suspend fun delete(id: Int): Boolean
}