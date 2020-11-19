package br.iesb.banco_sangue.banco

class BolsasDeSangue {

    private val bolsasDeSangue = mutableListOf<BolsaDeSangue>()
    private var qtd = getCount()

    fun add(tipo: BolsaDeSangue.TipoSanguineo, rh: BolsaDeSangue.SistemaRH) {
        bolsasDeSangue.add(BolsaDeSangue(tipo, rh))
        qtd++
    }


    fun getCount(tipo: BolsaDeSangue.TipoSanguineo? = null, rh: BolsaDeSangue.SistemaRH? = null): Int {

        if (tipo == null && rh == null)
            return bolsasDeSangue.size

        if (tipo == null && rh != null) {
            var count = 0
            bolsasDeSangue.forEach { bolsa ->
                if(rh == bolsa.getHR())
                    count++
            }
            return count
        }

       if(tipo!=null && rh==null) {
           var count = 0
           bolsasDeSangue.forEach { bolsa ->
               if(tipo == bolsa.getTipo())
                   count++
           }
           return count
       }

        var count = 0
        bolsasDeSangue.forEach { bolsa ->
            if(bolsa.getTipoAndHR()=="$tipo${rh!!.simbolo}")
                count++
        }
        print("$tipo${rh!!.simbolo}")
        return count
    }


    fun forEach(function: (BolsaDeSangue) -> Unit) {
        bolsasDeSangue.forEach { bolsa ->
            function(bolsa)
        }
    }
}
