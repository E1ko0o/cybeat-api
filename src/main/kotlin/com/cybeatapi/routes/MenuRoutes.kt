package com.cybeatapi.routes

import com.cybeatapi.models.MenuItem
import com.cybeatapi.models.menuStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allMenuRouting() {
    getMenuRoute()
    clearMenu()
    addMenu()
}

fun Route.getMenuRoute() {
    get("/menu") {
        if (menuStorage.isNotEmpty()) {
            call.respond(menuStorage)
        } else {
            return@get call.respondText(
                "Menu is empty",
                status = HttpStatusCode.OK
            )
        }
    }
}

fun Route.clearMenu() {
    delete("/menu") {
        val i = 0
        while (i != menuStorage.size) {
            menuStorage.removeAt(i)
        }
        call.respondText(
            "Menu cleared correctly",
            status = HttpStatusCode.Accepted
        )
    }
}

fun Route.addMenu() {
    post("/menu") {
        val menu = call.receive<List<MenuItem>>()
        menuStorage.addAll(menu)
        call.respondText(
            "Menu stored correctly",
            status = HttpStatusCode.Created
        )
    }
}