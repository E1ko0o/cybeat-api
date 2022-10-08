package com.cybeatapi.models

import org.jetbrains.exposed.sql.Table

data class Category(
    val id: Int,
    val name: String
)

object Categories: Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 32)

    override val primaryKey = PrimaryKey(id)
}