package com.cybeatapi.dao.dish

import com.cybeatapi.models.Dish

interface DAOFacadeDish {
    suspend fun getAll(): List<Dish>
    suspend fun getById(id: Int): Dish?
    suspend fun add(value: Dish): Dish?
    suspend fun update(id: Int, value: Dish): Boolean
    suspend fun deleteById(id: Int): Boolean
    suspend fun deleteAll(): Int
}