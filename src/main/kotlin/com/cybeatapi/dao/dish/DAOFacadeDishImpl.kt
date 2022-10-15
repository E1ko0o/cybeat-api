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
        id = row[Dishes.id].value,
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

    override suspend fun add(value: Dish): Dish? = dbQuery {
        val insertStatement = Dishes.insert {
            it[item] = value.item
            it[categoryId] = value.categoryId
            it[amount] = value.amount
            it[price] = value.price
            it[weight] = value.weight
            it[calories] = value.calories
            it[image] = value.image
            it[description] = value.description
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun update(id: Int, value: Dish): Boolean = dbQuery {
        Dishes.update({ Dishes.id eq id }) {
            it[item] = value.item
            it[categoryId] = value.categoryId
            it[amount] = value.amount
            it[price] = value.price
            it[weight] = value.weight
            it[calories] = value.calories
            it[image] = value.image
            it[description] = value.description
        } > 0
    }

    override suspend fun deleteById(id: Int): Boolean = dbQuery {
        Dishes.deleteWhere { Dishes.id eq id } > 0
    }

    override suspend fun deleteAll(): Int = dbQuery {
        Dishes.deleteAll()
    }
}

val dao: DAOFacadeDish = DAOFacadeDishImpl().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Dish(0, "Test item", 17, 1, (BigDecimal(1)), null, null, null, null))
        } //TODO delete
    }
}