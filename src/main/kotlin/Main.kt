package com.fyndefaultapps
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.netty.*
import io.ktor.server.engine.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){
        install(ContentNegotiation){
            json()
        }
        routing {
            get("/"){

                call.respondText ("Servidor funcoinando")
            }
            get("/cons"){
                call.respondText ("Consulta realizada com sucesso")
            }
            post("/message"){
                println(call.receiveText())
                call.respondText ("Recebido!")
            }

        }
    }.start(true)


}