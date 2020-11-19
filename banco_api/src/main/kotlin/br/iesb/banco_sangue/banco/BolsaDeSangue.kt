package br.iesb.banco_sangue.banco

class BolsaDeSangue(
        private val tipoSangue: TipoSanguineo,
        private val sistemaRH: SistemaRH
) {

    private var completo = getTipoAndHR()

    override fun toString() = getTipoAndHR()

    fun getHR() = sistemaRH
    fun getTipo() = tipoSangue
    fun getTipoAndHR() = "$tipoSangue${sistemaRH.simbolo}"

    enum class TipoSanguineo(val tipo: String) {
        A("A"),
        B("B"),
        O("O"),
        AB("AB");

        val positivo: String
            get() = "$tipo+"

        val negativo: String
            get() = "$tipo-"
    }

    enum class SistemaRH(var simbolo : String) {
        POSITIVO("+"),
        NEGATIVO("-");
    }
}


