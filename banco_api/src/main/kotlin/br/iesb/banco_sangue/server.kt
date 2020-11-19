package br.iesb.banco_sangue

import br.iesb.banco_sangue.banco.Triagem

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.request.receive
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

val bancoDeSangue: BancoDeSangue = BancoDeSangue();


fun main() {
    embeddedServer(Netty, 3333) {
        routing {
            install(ContentNegotiation) {
                gson {
                    ;
                    setPrettyPrinting()
                }
            }

            get("/doadores") {
                call.respond(bancoDeSangue.pessoa);
            }

            get("/banco/sangues") {
                call.respond(bancoDeSangue.banco);
            }


            get("/banco/quantidade") {
                bancoDeSangue.banco
                call.respond(bancoDeSangue.banco.getSangueList());
            }

            get("/doador") {
                var id = call.request.queryParameters["id"]
                var pessoaEncontrada = bancoDeSangue.validarPessoa(id)

                if (pessoaEncontrada.nome == null) {
                     call.respond("Não foi possivel encontrar este doador, verfique se os dados estão corretos e tente novamente!")
                }
                call.respond(bancoDeSangue.validarPessoa(id))


            }

            post("/doadores/cadastrar") {
                val doador = call.receive<Triagem>();
                call.respond(bancoDeSangue.cadastrarPessoa(doador));
            }

            post("/triagem") {
                var authToken: String? = call.request.headers["Token"]
                var id = call.request.queryParameters["id"]
                var doador = bancoDeSangue.validarPessoa(id)
                var updatedPerson = call.receive<Triagem>()



                if (authToken == "JV1OEX") {
                    call.respond(bancoDeSangue.validarDoacao(id, updatedPerson))
                } else {
                    call.respond("Token de autenticação inválidos")

                }
            }
        }
    }.start(wait = true);
}


