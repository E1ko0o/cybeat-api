package com.cybeatapi.routes

import com.cybeatapi.dao.order.dao
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allOrderRouting() {
    getOrdersRoute()
//    getOrderRoute()
//    totalizeOrderRoute()
}

private fun Route.getOrdersRoute() {
    get("/order") {
        call.respond(dao.getAll())
    }
}

//private fun Route.getOrderRoute() {
//    get("/order/{id?}") {
//        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
//            "No \"id\" field in body of request",
//            status = HttpStatusCode.BadRequest
//        )
//        val order = orderStorage.find { it.id == id } ?: return@get call.respondText(
//            "No order with id $id",
//            status = HttpStatusCode.NotFound
//        )
//        call.respond(order)
//    }
//}
//
//private fun Route.totalizeOrderRoute() {
//    get("/order/{id?}/total") {
//        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
//            "No \"id\" field in body of request",
//            status = HttpStatusCode.BadRequest
//        )
//        val order = orderStorage.find { it.id == id } ?: return@get call.respondText(
//            "No order with id $id",
//            status = HttpStatusCode.NotFound
//        )
//        val total = order.contents.sumOf { it.item.price * it.item.amount }
//        call.respond(total)
//    }
//}