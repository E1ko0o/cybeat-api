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
    deleteRoute()
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
        call.respond(dao.getById(id) ?: "No dish with id $id")
    }
}

private fun Route.addRoute() {
    post("/dish") {
        val dish = call.receive<Dish>()
        call.respond(dao.add(dish) ?: "An error occurred, try later")
    }
}

private fun Route.updateRoute() {
    put("/dish/{id}") {
        val dish = call.receive<Dish>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No\"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.edit(id, dish)) {
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

private fun Route.deleteRoute() {
    delete("/dish/{id}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.delete(id)) {
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
