package com.cybeatapi.routes

import com.cybeatapi.dao.category.dao
import com.cybeatapi.models.Category
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allCategoryRouting() {
    getCategoriesRoute()
    getCategoryByIdRoute()
    addCategoryRoute()
//    updateCategoryRoute()
//    deleteCategoryRoute()
}

fun Route.getCategoriesRoute() {
    get("/category") {
        call.respond(dao.getAll())
    }
}

fun Route.getCategoryByIdRoute() {
    get("/category/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        call.respond(dao.getById(id) ?: "No category with id $id")
    }
}

fun Route.addCategoryRoute() {
    post("/category") {
        val category = call.receive<Category>()
//        call.respond(dao.add(category.name) ?: "An error occurs, try later")
        call.respond(dao.add(category) ?: "An error occurs, try later")
    }
}

/*
fun Route.updateCategoryRoute() {
    put("/category/{id?}") {
        val category = call.receive<Category>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        if (id == category.id) {
            if (categoryStorage.removeIf { it.id == id }) {
                categoryStorage.add(category)
                call.respondText(
                    "Category updated correctly",
                    status = HttpStatusCode.Accepted
                )
            } else {
                call.respondText(
                    "No category with id $id",
                    status = HttpStatusCode.NotFound
                )
            }
        } else {
            call.respondText(
                "Id in body must be equal to id in parameters",
                status = HttpStatusCode.Conflict
            )
        }
    }
}

fun Route.deleteCategoryRoute() {
    delete("/category/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        if (categoryStorage.removeIf { it.id == id }) {
            call.respondText(
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
*/
