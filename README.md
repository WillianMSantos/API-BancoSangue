# PROJETO API DE BANCO DE SANGUE PARA POO
 A aplicação simula uma API de um Banco de Sangue.
 Uma pessoa pode se cadastrar para ser um doador, e é possível ver os registros de doadores e da quantidade de bolsas de sangue que estão armazenadas no banco.
 As bolsas de sangue, por padrão são de 500mL de sangue, de cada tipo
 A+, A-, B+, B-, O+, O-, AB+, AB-

 # Rotas
 / (GET)- Página padrão em branco, que pode ser usada para mostrar uma mensagem ou algum tipo de interface
 /banco (GET)- Página com informações da quantidade de bolsas de sangue por tipo sanguíneo
 /doadores (GET)- Página com informações de pessoas que já doaram sangue para o banco
 /doadores/cadastrar (POST)- Página que realiza o cadastro de novos doadores de sangue, recebendo um JSON no corpo da requisição

 # Formato do JSON para cadastro
 {
    "doador": {
        "nome": "",
        "documentacao": "",
        "idade": ,
        "sexo": "",
        "tipoSanguineo": "",
        "peso": ""
},
"tempoUltimaDoacao": 
} 

# Legenda dos "inputs"
nome (String) = Nome do doador

documentacao(String) = Documento de identidade do doador, podendo ser RG, CPF ou outros.

idade(Int) = Idade (em anos) do doador

sexo(String) = Sexo do doador (por padrão: "M" para masculino e "F" para feminino)

tipoSanguineo(String) = Tipo sanguíneo do doador. Caso seja um tipo inválido ou inexistente, o programa não deixa o usuário cadastrar e envia uma mensagem de erro

peso(Float) = Peso (em Kg) do doador. Caso o doador tenha menos de 50Kg, o programa não deixa o usuário cadastrar e envia uma mensagem de erro

tempoUltimaDoacao(Int) = Tempo desde a última doação do doador 
 
#