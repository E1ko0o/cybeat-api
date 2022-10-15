package com.cybeatapi.routes

import com.cybeatapi.dao.category.dao
import com.cybeatapi.models.Category
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allCategoryRouting() {
    getAllRoute()
    getByIdRoute()
    addRoute()
    updateRoute()
    deleteRoute()
}

private fun Route.getAllRoute() {
    get("/category") {
        call.respond(dao.getAll())
    }
}

private fun Route.getByIdRoute() {
    get("/category/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        call.respond(dao.getById(id) ?: "No category with id $id")
    }
}

private fun Route.addRoute() {
    post("/category") {
        val category = call.receive<Category>()
        call.respond(dao.add(category) ?: "An error occurred, try later")
    }
}

private fun Route.updateRoute() {
    put("/category/{id?}") {
        val category = call.receive<Category>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.edit(id, category)) {
            return@put call.respondText(
                "Category updated correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            return@put call.respondText(
                "No category with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteRoute() {
    delete("/category/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.delete(id)) {
            return@delete call.respondText(
                "Category removed correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            call.respondText(
                "No category with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}
