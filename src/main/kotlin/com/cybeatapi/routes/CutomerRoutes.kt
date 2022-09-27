package com.cybeatapi.routes

import com.cybeatapi.models.Customer
import com.cybeatapi.models.customerStorage
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

fun Route.getCustomersRoute() {
    get("/customer") {
        if (customerStorage.isNotEmpty()) {
            call.respond(customerStorage)
        } else {
            return@get call.respondText(
                "There is no customers",
                status = HttpStatusCode.OK
            )
        }
    }
}

fun Route.getCustomerByIdRoute() {
    get("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@get call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
            "No customer with id $id",
            status = HttpStatusCode.NotFound
        )
        call.respond(customer)
    }
}

fun Route.addCustomerRoute() {
    post("/customer") {
        val customer = call.receive<Customer>()
        customerStorage.add(customer)
        call.respondText(
            "Customer stored correctly",
            status = HttpStatusCode.Created
        )
    }
}

fun Route.updateCustomerRoute() {
    put("/customer/{id?}") {
        val newCostumer = call.receive<Customer>()
        val id = call.parameters["id"]?.toInt() ?: return@put call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        if (customerStorage.removeIf { it.id == id }) {
            customerStorage.add(newCostumer)
            call.respondText(
                "Customer updated correctly",
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

fun Route.deleteCustomerRoute() {
    delete("/customer/{id?}") {
        val id = call.parameters["id"]?.toInt() ?: return@delete call.respondText(
            "No \"id\" field",
            status = HttpStatusCode.BadRequest
        )
        if (customerStorage.removeIf { it.id == id }) {
            call.respondText(
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