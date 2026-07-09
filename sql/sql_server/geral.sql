CREATE TABLE Usuario (
	id INT,
	nome_usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(20) NOT NULL,

	CONSTRAINT pk_usuario PRIMARY KEY (id)
);

CREATE TABLE Pessoa (
	id_pessoa INT IDENTITY(1,1),
	cpf VARCHAR(11) NOT NULL UNIQUE,
	nome VARCHAR(40) NOT NULL,
	data_nasc DATE NOT NULL,

	CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
);

CREATE TABLE Acompanhante(
	id_pessoa INT,
	renda INT DEFAULT 1,
	ocupacao VARCHAR(40),
	endereco VARCHAR(80),
	localidade VARCHAR(20),
	telefone VARCHAR(11),
	cidade VARCHAR(20),
	beneficio VARCHAR(30) DEFAULT 'nao',
	uf VARCHAR(2),
	situacao VARCHAR(10),
	cadastro_unico VARCHAR(3) DEFAULT 'nao',
	problema_saude VARCHAR(30) DEFAULT 'nao',
	data_entrada DATE NOT NULL,

	-- Herança
	FOREIGN KEY (id_pessoa) REFERENCES Pessoa(id_pessoa),

	-- Definir Primary Key
	CONSTRAINT pk_acompanhante PRIMARY KEY (id_pessoa)
);

CREATE TABLE Paciente (
	id_paciente INT PRIMARY KEY,
	id_acompanhante INT NOT NULL,
	transporte VARCHAR(40),
	enfermidade VARCHAR(40),
	tratamento VARCHAR(20),
	observacao VARCHAR(200),
	vinculo VARCHAR(20),
	armario TINYINT,
	unidade TINYINT DEFAULT 1,
	acomodacao TINYINT,
	uti VARCHAR(10),

	-- Herança
	CONSTRAINT fk_paciente_pessoa 
		FOREIGN KEY (id_paciente)
		REFERENCES Pessoa(id_pessoa),

	-- Relação Paciente / Acompanhante
	CONSTRAINT fk_paciente_acompanhante
		FOREIGN KEY (id_acompanhante)
		REFERENCES Acompanhante(id_pessoa)
);

CREATE TABLE Ficha_dados (
	id_ficha INT,
	id_paciente INT,
	id_acompanhante INT,
	data_geracao DATE,

	-- PK
	CONSTRAINT pk_ficha PRIMARY KEY (id_ficha),

	-- Relação Acompanhante
	CONSTRAINT fk_ficha_acompanhante
		FOREIGN KEY (id_acompanhante)
		REFERENCES Acompanhante(id_pessoa),

	-- Relação Paciente
	CONSTRAINT fk_ficha_paciente
		FOREIGN KEY (id_paciente)
		REFERENCES Paciente(id_paciente)
);

CREATE TABLE Refeicao(
	id_refeicao INT,
	data_refeicao DATE,
	tipo VARCHAR(10),
	quantidade INT,

	CONSTRAINT pk_refeicao PRIMARY KEY (id_refeicao)
);