package com.cybeatapi.dao.customer

import com.cybeatapi.models.Customer
import java.util.*

interface DAOFacadeCustomer {
    suspend fun getAll(): List<Customer>
    suspend fun getById(id: Int): Customer?
    suspend fun add(value: Customer): Customer?
    suspend fun update(id: Int, value: Customer): Boolean
    suspend fun deleteById(id: Int): Boolean
    suspend fun deleteAll(): Int
}