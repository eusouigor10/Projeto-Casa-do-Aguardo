CREATE TABLE Pessoa (
	id_pessoa INT IDENTITY(1,1),
	cpf VARCHAR(11) NOT NULL UNIQUE,
	nome VARCHAR(40) NOT NULL,
	data_nasc DATE NOT NULL,

	CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
);

SELECT * FROM Pessoa;

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

SELECT * FROM Acompanhante;

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

SELECT * FROM Paciente