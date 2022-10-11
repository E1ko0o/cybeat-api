package com.cybeatapi.plugins

import com.cybeatapi.routes.allCategoryRouting
import com.cybeatapi.routes.allCustomerRouting
import com.cybeatapi.routes.allOrderRouting
import com.cybeatapi.routes.allMenuRouting
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        allCategoryRouting()
        allCustomerRouting()
        allOrderRouting()
        allMenuRouting()
    }
}
