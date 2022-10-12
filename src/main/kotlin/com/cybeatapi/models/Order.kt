package com.cybeatapi.models

import com.cybeatapi.utils.DateSerializer
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.*
import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: Int,
    @Serializable(DateSerializer::class)
    val date: Date,
    val dishesIds: List<Int>,
    val serverId: String,
    val orderId: Int
)

object Orders: Table() {
    val id = integer("id").autoIncrement().uniqueIndex()
    val date = datetime("date")
    val dishesIds = (integer("dishes_ids") references Dishes.id) // foreign key
    val serverId = varchar("server_id", 15) //abcd-abcde-abcd
    val orderId = integer("order_id")

    override val primaryKey = PrimaryKey(id)
}
