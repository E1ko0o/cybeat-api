package com.cybeatapi

import io.ktor.server.application.*
import com.cybeatapi.plugins.*

fun main(args: Array<String>): Unit =
        io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
}
/*
TODO
осталось:
авторизация (согласовать с парнями типы авторизации)
сделать модели бд
реализовать запросы к моделям
протестировать запросы
опубликовать
*/
