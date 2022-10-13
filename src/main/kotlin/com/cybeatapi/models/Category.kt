package com.cybeatapi.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable
data class Category(
    val id: Int,
    val name: String
)

object Categories : IntIdTable() {
    val name = varchar("name", 32)
}