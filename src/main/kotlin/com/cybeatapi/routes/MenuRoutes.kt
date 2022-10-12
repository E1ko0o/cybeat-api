package com.cybeatapi.routes

import com.cybeatapi.models.Dish
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.allMenuRouting() {
//    getMenuRoute()
//    clearMenu()
//    addMenu()
}

//private fun Route.getMenuRoute() {
//    get("/menu") {
//        if (itemStorage.isNotEmpty()) {
//            val items = listOf<Dish>()
//
//            call.respond(itemStorage)
//        } else {
//            return@get call.respondText(
//                "Menu is empty",
//                status = HttpStatusCode.OK
//            )
//        }
//    }
//}
//
//private fun Route.clearMenu() {
//    delete("/menu") {
//        val i = 0
//        while (i != itemStorage.size) {
//            itemStorage.removeAt(i)
//        }
//        call.respondText(
//            "Menu cleared correctly",
//            status = HttpStatusCode.Accepted
//        )
//    }
//}
//
//private fun Route.addMenu() {
//    post("/menu") {
//        val menu = call.receive<List<Int>>()
//        itemStorage.addAll(menu)
//        call.respondText(
//            "Menu stored correctly",
//            status = HttpStatusCode.Created
//        )
//    }
//}