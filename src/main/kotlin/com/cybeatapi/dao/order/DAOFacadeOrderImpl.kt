package com.cybeatapi.dao.order

import com.cybeatapi.dao.DatabaseFactory.dbQuery
import com.cybeatapi.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*
import com.cybeatapi.utils.DateTimeConverter as conv
import com.cybeatapi.utils.Converters as convs

class DAOFacadeOrderImpl : DAOFacadeOrder {
    private fun resultRow(row: ResultRow) = Order(
        id = row[Orders.id].value,
        date = conv().convertToDate(row[Orders.date]),
        dishesIds = convs().getIntegersFromString(row[Orders.dishesIds]),
        dishesPrices = convs().getIntegersFromString(row[Orders.dishesPrices]),
        serverId = row[Orders.serverId],
        orderId = row[Orders.orderId]
    )

    override suspend fun getAll(): List<Order> = dbQuery {
        Orders.selectAll().map(::resultRow)
    }

    override suspend fun getById(id: Int): Order? = dbQuery {
        Orders.select { Orders.id eq id }.map(::resultRow).singleOrNull()
    }

    override suspend fun add(value: Order): Order? = dbQuery {
        val insertStatement = Orders.insert {
            it[date] = conv().convertToLocalDateTime(value.date)
            it[dishesIds] = convs().getStringFromIntegers(value.dishesIds)
            it[dishesPrices] = convs().getStringFromIntegers(value.dishesPrices)
            it[serverId] = value.serverId
            it[orderId] = value.orderId
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun update(id: Int, value: Order): Boolean = dbQuery {
        Orders.update({ Orders.id eq id }) {
            it[date] = conv().convertToLocalDateTime(value.date)
            it[dishesIds] = convs().getStringFromIntegers(value.dishesIds)
            it[dishesPrices] = convs().getStringFromIntegers(value.dishesPrices)
            it[serverId] = value.serverId
            it[orderId] = value.orderId
        } > 0
    }

    override suspend fun deleteById(id: Int): Boolean = dbQuery {
        Orders.deleteWhere { Orders.id eq id } > 0
    }

    override suspend fun deleteAll(): Int = dbQuery {
        Orders.deleteAll()
    }
}

val dao: DAOFacadeOrder = DAOFacadeOrderImpl().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Order(1, Date(), listOf(7, 8), listOf(2, 1), "aaaa-aaaaa-aaaa", 1))
        } //TODO delete
    }
}