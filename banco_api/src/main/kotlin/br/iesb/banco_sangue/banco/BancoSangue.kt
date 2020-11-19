package br.iesb.banco_sangue.banco


class BancoSangue : Banco() {

    private val bancoDeSangue = BolsasDeSangue()

    fun addBolsaSangue(sangue: String) {

        when (sangue.toUpperCase()) {
            BolsaDeSangue.TipoSanguineo.A.positivo -> {
                //bolsaAp++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.A,
                        BolsaDeSangue.SistemaRH.POSITIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.A.negativo -> {
                //bolsaAn++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.A,
                        BolsaDeSangue.SistemaRH.NEGATIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.B.positivo -> {
                //bolsaBp++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.B,
                        BolsaDeSangue.SistemaRH.POSITIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.B.negativo -> {
                //bolsaBn++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.B,
                        BolsaDeSangue.SistemaRH.NEGATIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.O.positivo -> {
                //bolsaOp++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.O,
                        BolsaDeSangue.SistemaRH.POSITIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.O.negativo -> {
                //bolsaOn++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.O,
                        BolsaDeSangue.SistemaRH.NEGATIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.AB.positivo -> {
                //bolsaABp++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.AB,
                        BolsaDeSangue.SistemaRH.POSITIVO
                )
            }
            BolsaDeSangue.TipoSanguineo.AB.negativo -> {
                //bolsaABn++
                bancoDeSangue.add(
                        BolsaDeSangue.TipoSanguineo.AB,
                        BolsaDeSangue.SistemaRH.NEGATIVO
                )
            }
        }
    }

    fun getSangueList(): HashMap<String, HashMap<String, String>> {

        val retorno = HashMap<String, HashMap<String, String>>()
        val lista = HashMap<String, String>()

        retorno["listaDeSangues"] = lista

        BolsaDeSangue.TipoSanguineo.values().forEach { tipoSanguineo ->
            lista["$tipoSanguineo+"] = "${bancoDeSangue.getCount(tipoSanguineo, BolsaDeSangue.SistemaRH.POSITIVO)}"
            lista["$tipoSanguineo-"] = "${bancoDeSangue.getCount(tipoSanguineo, BolsaDeSangue.SistemaRH.NEGATIVO)}"
        }

        lista["total:"] = bancoDeSangue.getCount().toString()

        return retorno
    }
}
