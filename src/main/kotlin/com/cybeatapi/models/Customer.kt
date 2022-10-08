package com.cybeatapi.models

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.Date

data class Customer(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val registrationDate: Date
)

object Customers: Table() {
    val id = integer("id").autoIncrement()
    val firstName = varchar("first_name", 64)
    val lastName = varchar("last_name", 64)
    val phone = varchar("phone", 16)
    val registrationDate = datetime("registration_date").defaultExpression(CurrentDateTime)

    override val primaryKey = PrimaryKey(id)
}
