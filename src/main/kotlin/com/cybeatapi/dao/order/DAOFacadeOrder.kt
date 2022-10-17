package com.cybeatapi.dao.order

import com.cybeatapi.models.Order

interface DAOFacadeOrder {
    suspend fun getAll(): List<Order>
    suspend fun getById(id: Int): Order?
    suspend fun add(value: Order): Order?
    suspend fun update(id: Int, value: Order): Boolean
    suspend fun deleteById(id: Int): Boolean
    suspend fun deleteAll(): Int
}