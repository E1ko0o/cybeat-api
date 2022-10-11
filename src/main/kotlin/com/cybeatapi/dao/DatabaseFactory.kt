package com.cybeatapi.dao

import com.cybeatapi.models.*
import kotlinx.coroutines.Dispatchers
import java.sql.Connection
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory { // https://github.com/JetBrains/Exposed/wiki/DataBase-and-DataSource
    fun init() {
        val driver = "org.postgresql.Driver"
        val jdbcURL =
            "jdbc:postgresql://ec2-54-228-32-29.eu-west-1.compute.amazonaws.com:5432/d2v2st15j38lv4"
        val db = Database.connect(
            jdbcURL,
            driver,
            user = "rejvrjnerfllrc",
            password = "992494fd3f78867884a7f96b86ee60c0f616bf4ce4036234c30c9920fef7f59c"
        )
        transaction(db = db, transactionIsolation = Connection.TRANSACTION_SERIALIZABLE, repetitionAttempts = 2) {
            SchemaUtils.create(Customers)
            SchemaUtils.create(Categories)
            SchemaUtils.create(Dishes)
            SchemaUtils.create(Orders)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}