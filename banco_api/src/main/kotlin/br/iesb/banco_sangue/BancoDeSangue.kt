package br.iesb.banco_sangue

import br.iesb.banco_sangue.banco.BancoSangue
import br.iesb.banco_sangue.banco.DataDoacao
import br.iesb.banco_sangue.banco.Triagem
import kotlin.random.Random


class BancoDeSangue {

    private var listaBanco = mutableListOf<BancoSangue>()
    var banco = BancoSangue()
    var data = DataDoacao()
    val pessoa = mutableListOf<Triagem>()

    fun cadastrarPessoa(doador: Triagem): String {
        if (doador.tipoSanguineo?.let { doador.validarTipoSanguineo(it) }!!) {
            return "O tipo sangúineo informado não é válido, por favor tente novamente."
        } else if (!doador.peso?.let { doador.validarPeso(it) }!!) {
            return "Seu peso é abaixo do requerimento mínimo para realizar uma doação."
        } else if (!doador.idade?.let { doador.validarIdade(it) }!!) {
            return "Sua idade está fora dos requisitos mínimos para realizar uma doação."
        } else if (validardocumentacao(doador.documentacao)) {
            return "Já existe uma pessoa cadastrada com esse CPF"
        } else {

            //(meses com 30 dias = 4,6,9,11)
             var random30Day = Random.nextInt(from = 1, until = 30) ;
            var random31Day = Random.nextInt(from = 1, until = 31);
            var random28Day = Random.nextInt(from = 1, until = 28)
            var randomMonth = Random.nextInt(from = 1, until = 12);
            var donationDate: String?= null;

            if(randomMonth == 4 || randomMonth == 6 || randomMonth == 9 || randomMonth == 11) {
                donationDate = "$random30Day/$randomMonth/2021"
                doador.dataDoacao = donationDate
            } else if(randomMonth == 2){
                donationDate = "$random28Day/$randomMonth/2021"
                doador.dataDoacao = donationDate
            } else {
                donationDate = "$random31Day/$randomMonth/2021"
                doador.dataDoacao = donationDate
            }
            pessoa.add(doador)


            return "Obrigado por nos ajudar a salvar vidas. Seu cadastro foi realizado com sucesso!" +
                    " A data de sua doação é no dia $donationDate"
        }
        }

    fun validarDoacao(id: String?, updatedPerson: Triagem): String {
        var matchedPerson = validarPessoa(id)

        matchedPerson.temperatura = updatedPerson.temperatura
        matchedPerson.pressao = updatedPerson.pressao
        matchedPerson.pulsacao = updatedPerson.pulsacao
        matchedPerson.doou = true

        if (matchedPerson.nome == null){
            return "Não foi possivel encontrar este doador, verfique se os dados estão corretos e tente novamente!"
        }
        if (!matchedPerson.temperatura?.let { matchedPerson.validaTemperatura(it) }!!) {
            return "A temperatura não atingiu os requisitos mínimos para a doação"
        } else if (!matchedPerson.pulsacao?.let { matchedPerson.validaPulsacao(it) }!!){
            return "A pulsação não atingiu os requisitos mínimos para a doação"
        } else if (!matchedPerson.pressao?.let { matchedPerson.validaPressao(it) }!!){
            return "A pressão não atingiu os requisitos mínimos para a doação"
        }
        else {
            if(matchedPerson.doou!!) {
                matchedPerson.tipoSanguineo?.let { cadastrarSangue(it) }
            }
        }
        return "Dados atualizados com sucesso!"
    }

    fun validarPessoa(id: String?): Triagem {
        var matchedPerson = Triagem()
        pessoa.forEach{ pessoaDoadora ->
            if(id == pessoaDoadora.documentacao) {
                matchedPerson = pessoaDoadora
            }
        }
        return matchedPerson
    }

    private fun cadastrarSangue(sangue: String) {
        banco.addBolsaSangue(sangue)
        listaBanco.add(banco)
    }

    private fun validardocumentacao(documento: String?): Boolean {
        var matchedPerson = false
        pessoa.forEach{ pessoaDoadora ->
            if(documento == pessoaDoadora.documentacao) {
                matchedPerson = true
            }
        }
        return matchedPerson
    }

}
