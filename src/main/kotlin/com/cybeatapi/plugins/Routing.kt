package com.cybeatapi.plugins

import com.cybeatapi.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        allCategoryRouting()
        allCustomerRouting()
        allDishRouting()
        allOrderRouting()
        allMenuRouting()
    }
}
