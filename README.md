# Casa do Aguardo

Sistema desenvolvido em **Java** para gerenciamento de informações relacionadas à Casa do Aguardo, com uma estrutura organizada em camadas e banco de dados relacional.

## 📋 Sobre o projeto

O projeto tem como objetivo organizar e centralizar os dados utilizados pela Casa do Aguardo, incluindo informações de pessoas, pacientes, acompanhantes, fichas de dados, refeições e usuários.

A proposta de organização do sistema utiliza uma arquitetura em camadas, separando as responsabilidades de cada parte da aplicação. Essa separação facilita a manutenção, os testes e a evolução do projeto.

## 🛠️ Tecnologias

- **Java**
- **JavaFX** — interface gráfica planejada para o sistema
- **SQLite** — banco de dados previsto na estrutura da aplicação

## 🏗️ Arquitetura

A estrutura planejada para o sistema é dividida nos seguintes pacotes:

```text
src/
├── model/
├── repository/
├── service/
├── controller/
├── view/
├── database/
├── util/
└── Main.java
```

### `model`

Representa os dados e as entidades do sistema.

Exemplos:

- Pessoa
- Acompanhante
- Paciente
- Endereco
- Telefone
- Internamento
- Refeicao
- Usuario

### `repository`

Responsável pelo acesso e persistência dos dados no banco.

Principais operações:

- INSERT
- SELECT
- UPDATE
- DELETE
- Consultas específicas
- Conversão dos resultados do banco para objetos do `model`

Exemplos:

- `PessoaRepository`
- `AcompanhanteRepository`
- `PacienteRepository`
- `UsuarioRepository`

### `service`

Responsável pelas regras de negócio da aplicação.

Exemplos de responsabilidades:

- Validações
- Regras de cadastro e alteração
- Verificações antes do acesso ao banco
- Coordenação entre diferentes repositories
- Processamentos que não pertencem à interface

Exemplos:

- `PessoaService`
- `AcompanhanteService`
- `PacienteService`
- `RelatorioService`

### `controller`

Responsável por receber as ações da interface JavaFX e coordenar as operações necessárias.

Exemplos:

- Eventos de botões
- Navegação entre telas
- Captura dos dados dos formulários
- Chamadas aos Services
- Atualização da interface

Exemplos:

- `LoginController`
- `AcompanhanteController`
- `PacienteController`
- `RelatorioController`

### `view`

Responsável pela interface gráfica desenvolvida com JavaFX.

A camada deve conter os arquivos FXML e os componentes visuais das telas, como:

- Labels
- TextFields
- Buttons
- Tables
- ComboBoxes

A lógica de negócio deve permanecer na camada `service`, e não na `view`.

### `database`

Responsável pela configuração e inicialização do banco de dados.

Entre suas responsabilidades estão:

- Criação da conexão
- Definição do caminho do banco
- Inicialização do banco
- Execução dos scripts de criação das tabelas
- Configurações relacionadas ao banco

### `util`

Reúne funções auxiliares que podem ser reutilizadas em diferentes partes do sistema.

Exemplos:

- Formatação de datas
- Validação de CPF
- Formatação de telefone
- Utilidades para telas
- Conversões e funções genéricas

### `Main`

É o ponto de entrada da aplicação e será responsável por iniciar o sistema, inicializar o JavaFX, inicializar o banco e carregar a primeira tela.

## 🔄 Fluxo da aplicação

O fluxo planejado para as operações do sistema é:

```text
Usuário
   ↓
View (FXML)
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
View
```

Dessa forma, cada camada possui uma responsabilidade específica e a comunicação entre elas ocorre de maneira organizada.

## 🗄️ Banco de dados

O projeto possui scripts SQL organizados em:

```text
sql/
├── postgree/
│   └── geral.sql
│
└── sql_server/
    ├── geral.sql
    ├── tabela_acompanhante.sql
    ├── tabela_ficha_dados.sql
    ├── tabela_paciente.sql
    ├── tabela_pessoa.sql
    ├── tabela_refeicao.sql
    └── tabela_usuario.sql
```

As principais tabelas presentes nos scripts são:

- `Usuario`
- `Pessoa`
- `Acompanhante`
- `Paciente`
- `Ficha_dados`
- `Refeicao`

O relacionamento entre `Pessoa`, `Acompanhante` e `Paciente` utiliza chaves estrangeiras para representar a especialização/herança das entidades.

## 📁 Estrutura atual do projeto

A estrutura principal atualmente está organizada da seguinte forma:

```text
Projeto-Casa-do-Aguardo/
├── Projeto-Casa-do-Aguardo/
│   ├── .gitignore
│   ├── estrutura_pacotes_casa_do_aguardo.txt
│   ├── Projeto-Casa-do-Aguardo.iml
│   └── src/
│       └── Main.java
│
└── sql/
    ├── postgree/
    │   └── geral.sql
    │
    └── sql_server/
        ├── geral.sql
        ├── tabela_acompanhante.sql
        ├── tabela_ficha_dados.sql
        ├── tabela_paciente.sql
        ├── tabela_pessoa.sql
        ├── tabela_refeicao.sql
        └── tabela_usuario.sql
```

> **Observação:** a estrutura de pacotes `model`, `repository`, `service`, `controller`, `view`, `database` e `util` representa a organização planejada para o desenvolvimento do sistema. Na versão atual do projeto, essas camadas ainda estão em processo de implementação.

## 🚀 Como executar

### Pré-requisitos

- Java JDK instalado
- IntelliJ IDEA ou outra IDE compatível com Java
- Configuração do JavaFX quando as telas da aplicação forem implementadas
- Banco de dados conforme a configuração escolhida para o projeto

### Execução

1. Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

2. Abra o projeto na IDE.

3. Configure o JDK utilizado pelo projeto.

4. Configure as dependências do JavaFX quando necessário.

5. Execute a classe:

```text
Main.java
```

## 📌 Estado atual

O projeto encontra-se em desenvolvimento.

Atualmente, o repositório contém:

- Estrutura inicial do projeto Java.
- Classe `Main.java`.
- Scripts SQL para SQL Server.
- Script SQL para PostgreSQL.
- Definição da arquitetura em camadas.
- Modelagem inicial das entidades do sistema.

As camadas de interface, regras de negócio, persistência e conexão com o banco ainda devem ser implementadas conforme o desenvolvimento do projeto.

## 📐 Princípios da arquitetura

Cada pacote deve possuir uma responsabilidade clara:

- A **View** não deve executar SQL diretamente.
- O **Controller** não deve concentrar regras complexas de negócio.
- O **Repository** não deve decidir regras da aplicação.
- O **Model** não deve controlar a interface.
- O acesso ao banco deve ficar concentrado na camada de persistência/database.

## 👥 Projeto

**Casa do Aguardo**

Sistema desenvolvido para fins acadêmicos.
