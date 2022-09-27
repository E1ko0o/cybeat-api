package com.cybeatapi.routes

import com.cybeatapi.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allOrderRouting() {
    getAllOrdersRoute()
    getOrderRoute()
    totalizeOrderRoute()
}

fun Route.getAllOrdersRoute() {
    get("/order") {
        if (orderStorage.isNotEmpty()) {
            call.respond(orderStorage)
        } else {
            return@get call.respondText(
                "There is no orders",
                status = HttpStatusCode.OK
            )
        }
    }
}

fun Route.getOrderRoute() {
    get("/order/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        val order = orderStorage.find { it.id == id } ?: return@get call.respondText(
            "Order not found",
            status = HttpStatusCode.NotFound
        )
        call.respond(order)
    }
}

fun Route.totalizeOrderRoute() {
    get("/order/{id?}/total") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        val order = orderStorage.find { it.id == id } ?: return@get call.respondText(
            "Order not Found",
            status = HttpStatusCode.NotFound
        )
        val total = order.contents.sumOf { it.item.price * it.item.amount }
        call.respond(total)
    }
}