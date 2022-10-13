package com.cybeatapi.dao.dish

import com.cybeatapi.models.Dish

interface DAOFacadeDish {
    suspend fun getAll(): List<Dish>
    suspend fun getById(id: Int): Dish?
    suspend fun add(value: Dish): Dish?
    suspend fun edit(value: Dish): Boolean
    suspend fun delete(id: Int): Boolean
}