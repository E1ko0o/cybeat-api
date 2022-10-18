package com.cybeatapi.routes

import com.cybeatapi.dao.dish.dao
import com.cybeatapi.models.Dish
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allDishRouting() {
    getAllRoute()
    getByIdRoute()
    addRoute()
    updateRoute()
    deleteByIdRoute()
    deleteAllRoute()
}

private fun Route.getAllRoute() {
    get("/dish") {
        call.respond(dao.getAll())
    }
}

private fun Route.getByIdRoute() {
    get("/dish/{id}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        val value = dao.getById(id)
        if (value == null)
            call.respondText(
                "No dish with id $id",
                status = HttpStatusCode.NotFound
            )
        else
            call.respond(value)
    }
}

private fun Route.addRoute() {
    post("/dish") {
        val dish = call.receive<Dish>()
        val value =dao.add(dish)
        if (value == null)
            call.respondText(
                "An error occurred, try later",
                status = HttpStatusCode.NotFound
            )
        else
            call.respond(value)
    }
}

private fun Route.updateRoute() {
    put("/dish/{id}") {
        val dish = call.receive<Dish>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No\"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.update(id, dish)) {
            return@put call.respondText(
                "Dish updated correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            return@put call.respondText(
                "No dish with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteByIdRoute() {
    delete("/dish/{id}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.deleteById(id)) {
            return@delete call.respondText(
                "Dish removed correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            call.respondText(
                "No dish with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteAllRoute() {
    delete("/dish") {
        call.respondText(
            "${dao.deleteAll()} entries deleted",
            status = HttpStatusCode.Accepted
        )
    }
}
