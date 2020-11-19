package br.iesb.banco_sangue.banco

import br.iesb.banco_sangue.pessoa.PessoaDoadora
import kotlin.random.Random

class DataDoacao {
    val pessoa = mutableListOf<Triagem>()

    fun dataParaDoacao(doador: Triagem): String {
        var ano = Random.nextInt(2020, 2021);
        var trinta_dias = Random.nextInt(1, 30);
        var trinta_e_um_dias = Random.nextInt(1, 31);
        var vinte_oito_dias = Random.nextInt(1, 28);
        var mes = Random.nextInt(1, 12)
        var dataDoacao: String? = null

        when(mes){
            4 ,6, 9, 11 ->{ dataDoacao = "$trinta_dias/$mes/$ano"
            doador.dataDoacao = dataDoacao
            }
            2->{ dataDoacao =  "$vinte_oito_dias/$mes/$ano"
                doador.dataDoacao = dataDoacao
            }
            3, 5, 7, 8, 10, 12 ->{dataDoacao = "$trinta_e_um_dias/$mes/$ano"
                doador.dataDoacao = dataDoacao
            }
        }
        pessoa.add(doador)
        return "Valeu meu bom"
    }
}