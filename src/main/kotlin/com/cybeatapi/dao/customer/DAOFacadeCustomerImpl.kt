package com.cybeatapi.dao.customer

import com.cybeatapi.dao.DatabaseFactory.dbQuery
import com.cybeatapi.models.Customers
import com.cybeatapi.models.Customer
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import com.cybeatapi.utils.DateTimeConverter as conv
import java.util.*

class DAOFacadeImplCustomer : DAOFacadeCustomer {

    private fun resultRow(row: ResultRow) = Customer(
        id = row[Customers.id].value,
        firstName = row[Customers.firstName],
        lastName = row[Customers.lastName],
        phone = row[Customers.phone],
        registrationDate = conv().convertToDate(row[Customers.registrationDate]),
    )

    override suspend fun getAll(): List<Customer> = dbQuery {
        Customers.selectAll().map(::resultRow)
    }

    override suspend fun getById(id: Int): Customer? = dbQuery {
        Customers.select { Customers.id eq id }.map(::resultRow).singleOrNull()
    }

    override suspend fun add(value: Customer): Customer? = dbQuery {
        val insertStatement = Customers.insert {
            it[firstName] = value.firstName
            it[lastName] = value.lastName
            it[phone] = value.phone
            it[registrationDate] = conv().convertToLocalDateTime(value.registrationDate)
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun update(id: Int, value: Customer): Boolean = dbQuery {
        Customers.update({ Customers.id eq id }) {
            it[firstName] = value.firstName
            it[lastName] = value.lastName
            it[phone] = value.phone
            it[registrationDate] = conv().convertToLocalDateTime(value.registrationDate)
        } > 0
    }

    override suspend fun deleteById(id: Int): Boolean = dbQuery {
        Customers.deleteWhere { Customers.id eq id } > 0
    }

    override suspend fun deleteAll(): Int = dbQuery {
        Customers.deleteAll()
    }
}

val dao: DAOFacadeCustomer = DAOFacadeImplCustomer().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Customer(0, "Test name", "Test surname", "+79503332265", Date()))
        } //TODO delete
    }
}