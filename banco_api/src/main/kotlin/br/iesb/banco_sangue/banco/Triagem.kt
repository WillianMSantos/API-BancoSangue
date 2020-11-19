package br.iesb.banco_sangue.banco

import br.iesb.banco_sangue.pessoa.PessoaDoadora
import kotlin.random.Random

class Triagem: PessoaDoadora() {
    var dataDoacao: String ?=null
    var tempoUltimaDoacao: Int?= null
    var doou: Boolean ?= false


    fun validarTipoSanguineo(tipoSanguineo: String): Boolean {
        return tipoSanguineo != "A+" && tipoSanguineo != "a+" && tipoSanguineo != "A-" && tipoSanguineo != "a-"
                && tipoSanguineo != "B+" && tipoSanguineo != "b+" && tipoSanguineo != "B-" && tipoSanguineo != "b-" &&
                tipoSanguineo != "AB+" && tipoSanguineo != "ab+" && tipoSanguineo != "AB-" && tipoSanguineo != "ab-" &&
                tipoSanguineo != "O+" && tipoSanguineo != "o+" && tipoSanguineo != "O-" && tipoSanguineo != "o-"
    }

    fun validarPeso(peso: Float): Boolean {
    return peso >= 50
    }

    fun validarIdade(idade: Int): Boolean{
    return idade in 18..65
    }

    fun validaPulsacao(pulsacao: Int): Boolean {
        return pulsacao  <=140
    }

    fun validaPressao(pressao: Int): Boolean {
        return pressao  <=90
    }

    fun validaTemperatura(temperatura: Int): Boolean {
        return temperatura <37
    }

}
