package com.cybeatapi.dao.category

import com.cybeatapi.dao.DatabaseFactory.dbQuery
import com.cybeatapi.models.Categories
import com.cybeatapi.models.Category
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImplCategory : DAOFacadeCategory {
    private fun resultRow(row: ResultRow) = Category(
        id = row[Categories.id].value,
        name = row[Categories.name],
    )

    override suspend fun getAll(): List<Category> = dbQuery {
        Categories.selectAll().map(::resultRow)
    }

    override suspend fun getById(id: Int): Category? = dbQuery {
        Categories
            .select { Categories.id eq id }
            .map(::resultRow)
            .singleOrNull()
    }

    override suspend fun add(value: Category): Category? = dbQuery {
        val insertStatement = Categories.insert {
            it[name] = value.name
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRow)
    }

    override suspend fun update(id: Int, value: Category): Boolean = dbQuery {
        Categories.update({ Categories.id eq id }) {
            it[name] = value.name
        } > 0
    }

    override suspend fun deleteById(id: Int): Boolean = dbQuery {
        Categories.deleteWhere { Categories.id eq id } > 0
    }

    override suspend fun deleteAll(): Int = dbQuery {
        Categories.deleteAll()
    }
}

val dao: DAOFacadeCategory = DAOFacadeImplCategory().apply {
    runBlocking {
        if (getAll().isEmpty()) {
            add(Category(0, "Test category"))
        } //TODO delete
    }
}
