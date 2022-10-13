package com.cybeatapi.models

import com.cybeatapi.utils.DateSerializer
import org.jetbrains.exposed.sql.javatime.CurrentDateTime
import org.jetbrains.exposed.sql.javatime.datetime
import java.util.Date
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable
data class Customer(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    @Serializable(DateSerializer::class)
    val registrationDate: Date
)

object Customers: IntIdTable() {
    val firstName = varchar("first_name", 64)
    val lastName = varchar("last_name", 64)
    val phone = varchar("phone", 16)
    val registrationDate = datetime("registration_date").defaultExpression(CurrentDateTime)
}
