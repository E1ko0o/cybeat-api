package com.cybeatapi.models

import com.cybeatapi.utils.DateSerializer
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable
data class Order(
    val id: Int,
    @Serializable(DateSerializer::class)
    val date: Date,
    val dishesIds: List<Int>,
    val serverId: String,
    val orderId: Int
)

object Orders: IntIdTable() {
    val date = datetime("date")
    val dishesIds = text("dishes_ids") // foreign key Dishes.id
    val serverId = varchar("server_id", 15) //abcd-abcde-abcd
    val orderId = integer("order_id")
}
