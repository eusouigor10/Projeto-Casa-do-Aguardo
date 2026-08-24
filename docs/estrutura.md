ESTRUTURA DE PACOTES - SISTEMA CASA DO AGUARDO
Java + JavaFX + SQLite

Objetivo
--------
Organizar o sistema em camadas, separando responsabilidades e facilitando
a manutenção, testes e evolução do projeto.


# 1. model
---------
Responsável por representar os dados e as entidades do sistema.

Contém:
- Classes que representam as entidades do banco.
- Atributos e relacionamentos entre entidades.
- Getters, setters, construtores e métodos simples relacionados aos dados.

Exemplos:
- Pessoa
- Acompanhante
- Paciente
- Endereco
- Telefone
- Internamento
- Refeicao
- Usuario


# 2. repository
-------------
Responsável pelo acesso aos dados no banco SQLite.

Contém:
- INSERT
- SELECT
- UPDATE
- DELETE
- Consultas específicas.
- Conversão dos resultados do banco para objetos do model.

Exemplos:
- PessoaRepository
- AcompanhanteRepository
- PacienteRepository
- UsuarioRepository


# 3. service
-----------
Responsável pelas regras de negócio do sistema.

Contém:
- Validações.
- Regras de cadastro e alteração.
- Verificações antes de acessar o banco.
- Coordenação entre diferentes repositories.
- Processamentos que não pertencem à interface.

Exemplos:
- PessoaService
- AcompanhanteService
- PacienteService
- RelatorioService


# 4. controller
-------------
Responsável por receber as ações da interface JavaFX e coordenar as
operações necessárias.

Contém:
- Eventos de botões.
- Navegação entre telas.
- Captura dos dados dos formulários.
- Chamadas aos Services.
- Atualização da interface.

Exemplos:
- LoginController
- AcompanhanteController
- PacienteController
- RelatorioController


# 5. view
--------
Responsável pela interface gráfica do JavaFX.

Contém:
- Arquivos FXML das telas.
- Estrutura visual dos componentes.
- Labels, TextFields, Buttons, Tables, ComboBoxes etc.

Observação:
A lógica de negócio deve ficar no Service, e não na View.


# 6. database
-----------
Responsável pela configuração e inicialização do banco SQLite.

Contém:
- Criação da conexão com SQLite.
- Caminho do arquivo .db.
- Inicialização do banco.
- Execução do script de criação das tabelas.
- Configurações relacionadas ao banco.

Exemplos:
- DatabaseConnection
- DatabaseInitializer


# 7. util
--------
Responsável por funcionalidades auxiliares e reutilizáveis.

Contém:
- Formatação de datas.
- Validação de CPF.
- Formatação de telefone.
- Utilidades para telas.
- Conversões e funções genéricas.

Regra:
Só colocar aqui funções realmente reutilizáveis e que não pertençam
claramente a outra camada.


# 8. Main / aplicação
-------------------
Responsável por iniciar o sistema.

Funções principais:
- Inicializar o JavaFX.
- Inicializar o banco SQLite.
- Carregar a primeira tela.
- Configurar o ciclo inicial da aplicação.


FLUXO GERAL
-----------

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
SQLite
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
View


RESUMO DAS RESPONSABILIDADES
----------------------------

model       → O que são os dados?
repository  → Como acessar os dados?
service     → Quais regras o sistema deve aplicar?
controller  → Como a interface conversa com o sistema?
view        → Como o sistema aparece para o usuário?
database    → Como o banco é criado e acessado?
util        → Funções auxiliares reutilizáveis?
Main        → Como o sistema começa?


PRINCÍPIO PRINCIPAL
-------------------

Cada pacote deve ter uma responsabilidade clara.

A interface não deve executar SQL diretamente.
O Controller não deve conter regras complexas de negócio.
O Repository não deve decidir regras da aplicação.
O Model não deve controlar a interface.
O acesso ao SQLite deve ficar concentrado na camada de persistência/database.
