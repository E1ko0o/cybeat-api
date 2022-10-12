package com.cybeatapi.dao.dish

import com.cybeatapi.dao.DatabaseFactory.dbQuery
import com.cybeatapi.models.Dish
import com.cybeatapi.models.Dishes
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.math.BigDecimal

class DAOFacadeDishImpl : DAOFacadeDish {
    private fun resultRow(row: ResultRow) = Dish(
        id = row[Dishes.id],
        item = row[Dishes.item],
        categoryId = row[Dishes.categoryId],
        amount = row[Dishes.amount],
        price = row[Dishes.price],
        weight = row[Dishes.weight],
        calories = row[Dishes.calories],
        image = row[Dishes.image],
        description = row[Dishes.description],
    )

    override suspend fun getAll(): List<Dish> = dbQuery {
        Dishes.selectAll().map(::resultRow)
    }

    override suspend fun getById(id: Int): Dish? = dbQuery {
        Dishes.select { Dishes.id eq id }.map(::resultRow).singleOrNull()
    }

    override suspend fun add(dish: Dish): Dish? = dbQuery {
        val insertStatement = Dishes.insert {
            it[item] = dish.item
            it[categoryId] = dish.categoryId
            it[amount] = dish.amount
            it[price] = dish.price
            it[weight] = dish.weight
            it[calories] = dish.calories
            it[image] = dish.image
            it[description] = dish.description
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun edit(dish: Dish): Boolean = dbQuery {
        Dishes.update({ Dishes.id eq dish.id }) {
            it[item] = dish.item
            it[categoryId] = dish.categoryId
            it[amount] = dish.amount
            it[price] = dish.price
            it[weight] = dish.weight
            it[calories] = dish.calories
            it[image] = dish.image
            it[description] = dish.description
        } > 0
    }

    override suspend fun delete(id: Int): Boolean = dbQuery {
        Dishes.deleteWhere { Dishes.id eq id } > 0
    }
}

val dao: DAOFacadeDish = DAOFacadeDishImpl().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Dish(0, "Test item", 1, 1, (BigDecimal(1)), null, null, null, null))
        } //TODO delete
    }
}