package com.cybeatapi.models

import com.cybeatapi.utils.BigDecimalSerializer
import java.math.BigDecimal
import org.jetbrains.exposed.sql.Table
import kotlinx.serialization.Serializable

@Serializable
data class Dish(
    val id: Int,
    val item: String,
    val categoryId: Int,
    val amount: Int,
    @Serializable(BigDecimalSerializer::class)
    var price: BigDecimal,
    val weight: Int?,
    val calories: Int?,
    val image: String?,
    val description: String?
)

object Dishes: Table() {
    val id = integer("id").autoIncrement().uniqueIndex()
    val item = varchar("name", 64)
    val categoryId = (integer("category_id") references Categories.id) // foreign key
    val amount = integer("amount")
    var price = decimal("price", 9, 2) // decimal like "1234567.89"
    val weight = integer("weight").nullable()
    val calories = integer("calories").nullable()
    val image = varchar("image", 256).nullable()
    val description = varchar("description", 128).nullable()

    override val primaryKey = PrimaryKey(id)

}
