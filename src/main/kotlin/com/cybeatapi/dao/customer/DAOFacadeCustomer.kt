package com.cybeatapi.dao.customer

import com.cybeatapi.models.Customer
import java.util.*

interface DAOFacadeCustomer {
    suspend fun getAll(): List<Customer>
    suspend fun getById(id: Int): Customer?
    suspend fun add(customer: Customer): Customer?
    suspend fun edit(customer: Customer): Boolean
    suspend fun delete(id: Int): Boolean
}