package com.cybeatapi.routes

import com.cybeatapi.dao.customer.dao
import com.cybeatapi.models.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allCustomerRouting() {
    getAllRoute()
    getByIdRoute()
    addRoute()
    updateRoute()
    deleteByIdRoute()
    deleteAllRoute()
}

private fun Route.getAllRoute() {
    get("/customer") {
        call.respond(dao.getAll())
        return@get call.respondText(
            "There is no customers",
            status = HttpStatusCode.OK
        )

    }
}

private fun Route.getByIdRoute() {
    get("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        call.respond(dao.getById(id) ?: "No customer with id $id")
    }
}

private fun Route.addRoute() {
    post("/customer") {
        val customer = call.receive<Customer>()
        call.respond(dao.add(customer) ?: "An error occurred, try later")
    }
}

private fun Route.updateRoute() {
    put("/customer/{id?}") {
        val newCustomer = call.receive<Customer>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.update(id, newCustomer)) {
            return@put call.respondText(
                "Customer updated correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            return@put call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteByIdRoute() {
    delete("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.deleteById(id)) {
            return@delete call.respondText(
                "Customer removed correctly",
                status = HttpStatusCode.Accepted
            )
        } else {
            call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
        }
    }
}

private fun Route.deleteAllRoute() {
    delete("/customer") {
        call.respondText(
            "${dao.deleteAll()} entries deleted",
            status = HttpStatusCode.Accepted
        )
    }
}