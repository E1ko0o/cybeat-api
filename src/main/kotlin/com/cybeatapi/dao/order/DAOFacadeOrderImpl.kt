package com.cybeatapi.dao.order

import com.cybeatapi.dao.DatabaseFactory.dbQuery
import com.cybeatapi.dao.dish.DAOFacadeDish
import com.cybeatapi.models.*
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.util.*
import com.cybeatapi.utils.DateTimeConverter as conv
import com.cybeatapi.utils.IdsUtil as ids

class DAOFacadeOrderImpl : DAOFacadeOrder {
    private fun resultRow(row: ResultRow) = Order(
        id = row[Orders.id].value,
        date = conv().convertToDate(row[Orders.date]),
        dishesIds = ids().getIdsFromString(row[Orders.dishesIds]),
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
//        for (i in value.dishesIds) {
//            if ()
//        } TODO check if dishesIds exist
        val insertStatement = Orders.insert {
            it[date] = conv().convertToLocalDateTime(value.date)
            it[dishesIds] = ids().getStringFromIds(value.dishesIds)
            it[serverId] = value.serverId
            it[orderId] = value.orderId
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun edit(value: Order): Boolean = dbQuery {
//        for (i in value.dishesIds) {
//            if ()
//        } TODO check if dishesIds exist
        Orders.update({ Orders.id eq value.id }) {
            it[date] = conv().convertToLocalDateTime(value.date)
            it[dishesIds] = ids().getStringFromIds(value.dishesIds)
            it[serverId] = value.serverId
            it[orderId] = value.orderId
        } > 0
    }

    override suspend fun delete(id: Int): Boolean = dbQuery {
        Orders.deleteWhere { Orders.id eq id } > 0
    }
}

val dao: DAOFacadeOrder = DAOFacadeOrderImpl().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Order(1, Date(), listOf(1, 2), "aaaa-aaaaa-aaaa", 1))
        } //TODO delete
    }
}