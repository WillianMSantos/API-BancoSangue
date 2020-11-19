package br.iesb.banco_sangue.pessoa

import java.util.*

open class PessoaDoadora {
    var id: String ?= UUID.randomUUID().toString()
    var nome: String?=null
    var documentacao: String?=null
    var idade: Int?=null
    var sexo: String?=null
    var tipoSanguineo: String?=null
    var peso: Float?=null
    var temperatura: Int? = null
    var pressao: Int? = null
    var pulsacao: Int? = null
}