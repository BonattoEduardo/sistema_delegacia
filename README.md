# sistema_delegacia
Sistema desenvolvido para o primeiro trabalho da disciplina TSI35A - Tópicos Avançados em T.I.

## Requisição JSON
```
{
    "idBoletimFurtoVeiculo": "",
    "dataOcorrencia": "2023-05-05",
    "periodoOcorrencia": "TARDE",
    "parte": {
        "nome": "Fulano de Tal",
        "email": "fulaninho@fulan.com.br",
        "telefone": "(45) 9 9999-9999",
        "tipoEnvolvimento": "VITIMA"
    },
    "localOcorrencia": {
        "logradouro": "Rua Pirati",
        "numero": "222",
        "bairro": "Lebrão",
        "cidade": "Toledo",
        "estado": "PR"
    },
    "veiculoFurtado": {
        "anoFabricacao": 2022,
        "cor": "azul",
        "marca": "Renault",
        "tipoVeiculo": "AUTOMOVEL",
        "emplacamento": {
            "placa": "ACD13V3",
            "estado": "PR",
            "cidade": "Toledo"
        }
    }
}
```

## Apresentação
[Slides](https://docs.google.com/presentation/d/1gXvakH0zOO6zbkFrob9Nj0B4GHeS8vF15TL9b5BjiUA/edit?usp=drivesdk)

### Tópicos Apresentação

- Falar sobre os objetivos do trabalho
- Falar sobre as tecnologias (framework e bibliotecas) utilizadas
- Falar sobre a arquitetura do sistema
    - Falar sobre as características
    - Falar sobre a estrutura de pastas

- Falar sobre os modelos
    - Falar sobre os enums

- Falar sobre os controllers
    - Falar sobre os DTOs
    - Mostrar interfaces da API

- Falar sobre os services
    - Falar sobre as validações aplicadas

- Falar sobre os repositories
    - Falar sobre os métodos de filtragem

- Falar sobre o tratamento de exeções
- Falar sobre o carregamento do arquivo CSV (DataInitializer)

### Validações

- BoletimFurtoVeiculo
    - dataOcorrencia: não pode ser no futuro ou nulo
    - periodoOcorrencia: tem que estar dentro das opções e não pode ser nulo

- Parte
    - nome: não pode ser vazio
    - email: tem que ser um formato válido
    - telefone: deve ser um formato válido

- Endereco
    - cidade: não pode ser nulo
    - estado: não pode ser nulo

- Veiculo
    - cor: não pode ser nulo
    - marca: não pode ser nulo
    - tipoVeiculo: Tem que estar entro das opções e não pose ser nulo