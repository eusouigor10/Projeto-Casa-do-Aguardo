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