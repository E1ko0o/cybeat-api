package com.cybeatapi.dao.order

import com.cybeatapi.models.Order

interface DAOFacadeOrder {
    suspend fun getAll(): List<Order>
    suspend fun getById(id: Int): Order?
    suspend fun add(value: Order): Order?
    suspend fun edit(value: Order): Boolean
    suspend fun delete(id: Int): Boolean
}