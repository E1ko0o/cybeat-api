package com.cybeatapi.dao.category

import com.cybeatapi.models.Category

interface DAOFacadeCategory {
    suspend fun getAll(): List<Category>
    suspend fun getById(id: Int): Category?
    suspend fun add(value: Category): Category?
    suspend fun update(id: Int, value: Category): Boolean
    suspend fun deleteById(id: Int): Boolean
    suspend fun deleteAll(): Int
}