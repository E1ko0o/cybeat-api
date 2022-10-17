package com.cybeatapi.routes

import com.cybeatapi.dao.order.dao
import com.cybeatapi.models.Order
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.math.BigDecimal

fun Route.allOrderRouting() {
    getAllRoute()
    getByIdRoute()
    calculateOrderPriceRoute()
    addRoute()
    updateRoute()
    deleteByIdRoute()
    deleteAllRoute()
}

private fun Route.getAllRoute() {
    get("/order") {
        call.respond(dao.getAll())
    }
}

private fun Route.getByIdRoute() {
    get("/order/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        call.respond(dao.getById(id) ?: "No order with id $id")
    }
}

private fun Route.calculateOrderPriceRoute() {
    get("/order/{id?}/price") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        val order: Order = dao.getById(id) ?: return@get call.respondText(
            "No order with id $id",
            status = HttpStatusCode.NotFound
        )
        var sum = BigDecimal(0)
        for (i in 0 until order.dishesIds.size) {
            sum += (
                    com.cybeatapi.dao.dish.dao.getById(order.dishesIds[i])?.price
                        ?.times(BigDecimal(order.dishesPrices[i])) ?: BigDecimal(0)
                    )
        }
        call.respond(sum)
    }
}

private fun Route.addRoute() {
    post("/order") {
        val order = call.receive<Order>()
        call.respond(dao.add(order) ?: "An error occurred, try later")
    }
}

private fun Route.updateRoute() {
    put("/order/{id?}") {
        val order = call.receive<Order>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.update(id, order)) {
            return@put call.respondText(
                "Order updated correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            return@put call.respondText(
                "No order with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteByIdRoute() {
    delete("/order/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.deleteById(id)) {
            return@delete call.respondText(
                "Order removed correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            call.respondText(
                "No order with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteAllRoute() {
    delete("/order") {
        call.respondText(
            "${dao.deleteAll()} entries deleted",
            status = HttpStatusCode.Accepted
        )
    }
}
