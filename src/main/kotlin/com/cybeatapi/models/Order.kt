package com.cybeatapi.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.*

data class Order(
    val id: Int,
    val date: Date,
    val dishesIds: List<Int>,
    val serverId: String,
    val orderId: Int
)

object Orders: Table() {
    val id = integer("id").autoIncrement()
    val date = datetime("date")
    val dishesIds = (integer("dishes_ids") references Dishes.id) // foreign key
    val serverId = varchar("server_id", 15) //abcd-abcde-abcd
    val orderId = integer("order_id")

    override val primaryKey = PrimaryKey(id)
}
