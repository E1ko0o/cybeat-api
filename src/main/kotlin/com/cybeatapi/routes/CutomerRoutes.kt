package com.cybeatapi.routes

import com.cybeatapi.dao.customer.dao
import com.cybeatapi.models.Customer
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allCustomerRouting() {
    getCustomersRoute()
    getCustomerByIdRoute()
    addCustomerRoute()
    updateCustomerRoute()
    deleteCustomerRoute()
}

private fun Route.getCustomersRoute() {
    get("/customer") {
            call.respond(dao.getAll())
            return@get call.respondText(
                "There is no customers",
                status = HttpStatusCode.OK
            )

    }
}

private fun Route.getCustomerByIdRoute() {
    get("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        call.respond(dao.getById(id) ?: "No customer with id $id")
    }
}

private fun Route.addCustomerRoute() {
    post("/customer") {
        val customer = call.receive<Customer>()
        call.respond(dao.add(customer) ?: "An error occurred, try later")
    }
}

private fun Route.updateCustomerRoute() {
    put("/customer/{id?}") {
        val newCustomer = call.receive<Customer>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (id == newCustomer.id) {
            if (dao.edit(newCustomer)) {
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
        } else {
            return@put call.respondText(
                "Id in body must be equal to id in parameters",
                status = HttpStatusCode.Conflict
            )
        }
    }
}

private fun Route.deleteCustomerRoute() {
    delete("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field in body of request",
            status = HttpStatusCode.BadRequest
        )
        if (dao.delete(id)) {
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