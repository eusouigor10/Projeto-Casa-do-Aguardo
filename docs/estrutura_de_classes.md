ESQUEMA DE CLASSES - CASA DO AGUARDO
Java + JavaFX + SQLite

Estrutura de pacotes
====================
br.com.casadoaguardo
├── Main
├── model
├── view
├── controller
├── service
├── repository
├── database
└── util


# 1. model
========
Representa as entidades e os dados do sistema. As classes daqui não devem
conter lógica de interface nem executar SQL.

Pessoa
- idPessoa : Long
- nome : String
- dataNascimento : LocalDate
- cpf : String

Acompanhante extends Pessoa
- cadastroUnico : String
- problemaSaude : String
- dataEntrada : LocalDate
- dataSaida : LocalDate
- renda : BigDecimal
- ocupacao : String
- local : String
- beneficiosGoverno : String
- status : String
- autorizacaoImagem : boolean
- rua : String
- numeroCasa : String
- cidade : String
- uf : String

Paciente extends Pessoa
- enfermidade : String
- tratamento : String
- transporte : String
- vinculo : String
- observacao : String

AcompanhanteTelefone
- idTelefone : Long
- telefone : String
- acompanhante : Acompanhante

PacienteInternamento
- idInternamento : Long
- uti : boolean
- acomodacao : String
- unidade : String
- armario : String
- paciente : Paciente

Refeicao
- idRefeicao : Long
- data : LocalDate
- tipo : String
- qtd : Integer

Usuario
- idUsuario : Long
- nomeUsuario : String
- senha : String

Relacionamentos principais
- Acompanhante 1:N Paciente, por meio de Acompanhamento.
- Acompanhante 1:N AcompanhanteTelefone.
- Paciente 1:N PacienteInternamento.
- Pessoa é a superclasse de Acompanhante e Paciente.


2. view
========
Contém as classes responsáveis pela construção visual das telas JavaFX.
Como a equipe decidiu não utilizar FXML, as interfaces serão classes Java.

Exemplos sugeridos:
- LoginView
- MenuView
- AcompanhanteView
- PacienteView
- InternamentoView
- RefeicaoView
- UsuarioView
- RelatorioView

Responsabilidade:
- Criar componentes JavaFX.
- Organizar layouts, tabelas, formulários e botões.
- Encaminhar eventos para os Controllers.

Não deve:
- Executar SQL diretamente.
- Conter regras de negócio complexas.


3. controller
=============
Faz a ponte entre a View e a camada de negócio.

Exemplos:
- LoginController
- AcompanhanteController
- PacienteController
- InternamentoController
- RefeicaoController
- UsuarioController
- RelatorioController

Responsabilidade:
- Receber eventos da interface.
- Ler os dados dos campos.
- Montar/receber objetos do model.
- Chamar os Services.
- Atualizar a View com os resultados.


4. service
==========
Concentra as regras de negócio.

Exemplos:
- LoginService
- AcompanhanteService
- PacienteService
- InternamentoService
- RefeicaoService
- UsuarioService
- RelatorioService

Responsabilidade:
- Validar dados.
- Aplicar regras do sistema.
- Coordenar operações que envolvem mais de um Repository.
- Impedir operações inválidas antes do acesso ao banco.


5. repository
=============
Responsável pela persistência dos dados no SQLite.

Exemplos:
- PessoaRepository
- AcompanhanteRepository
- PacienteRepository
- AcompanhanteTelefoneRepository
- PacienteInternamentoRepository
- RefeicaoRepository
- UsuarioRepository

Responsabilidade:
- INSERT.
- SELECT.
- UPDATE.
- DELETE.
- Consultas específicas.
- Mapeamento entre ResultSet e objetos do model.

Regra importante: Repository acessa o banco; não decide regras de negócio.


6. database
===========
Responsável pela infraestrutura do SQLite.

Classes sugeridas:
- DatabaseConnection
  - Abre e fornece conexões SQLite.
  - Configura foreign keys.

- DatabaseInitializer
  - Verifica/cria o arquivo .db.
  - Executa o script de criação das tabelas na primeira execução.

- DatabaseScript (opcional)
  - Centraliza o carregamento do schema.sql caso a equipe prefira não
    manter o SQL diretamente em uma classe Java.


7. util
========
Funções auxiliares e reutilizáveis que não pertencem claramente a outra camada.

Exemplos:
- DateUtil
- CpfUtil
- ValidationUtil
- FormatUtil
- AlertUtil

Evitar transformar util em um pacote de funções aleatórias. Cada utilitário
precisa ter uma responsabilidade genérica e reutilizável.


8. Main
=======
Ponto de entrada da aplicação.

Responsabilidade:
- Inicializar o JavaFX.
- Inicializar o SQLite.
- Abrir a primeira View.
- Configurar o ciclo inicial da aplicação.


FLUXO DA APLICAÇÃO
==================

View
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
DatabaseConnection
  ↓
SQLite

E no retorno:
SQLite → Repository → Service → Controller → View


OBSERVAÇÃO SOBRE O DER FINAL
============================
O DER final não possui uma entidade ENDEREÇO separada. Portanto, rua,
número da casa, cidade e UF foram considerados atributos de ACOMPANHANTE.

ACOMPANHAMENTO é um relacionamento entre ACOMPANHANTE e PACIENTE e não
possui atributos próprios.

TELEFONIA é um relacionamento entre ACOMPANHANTE e ACOMPANHANTE_TELEFONE.

INTERNAMENTO é um relacionamento entre PACIENTE e PACIENTE_INTERNAMENTO.
A cardinalidade indicada no DER é 1:N, portanto um paciente pode possuir
vários registros de internamento.
