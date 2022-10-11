package com.cybeatapi.dao.category

import com.cybeatapi.models.Category

interface DAOFacadeCategory {
    suspend fun getAll(): List<Category>
    suspend fun getById(id: Int): Category?
    suspend fun add(category: Category): Category?
    suspend fun edit(category: Category): Boolean
    suspend fun delete(id: Int): Boolean
}