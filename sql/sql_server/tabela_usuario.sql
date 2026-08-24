CREATE TABLE Usuario (
	id INT,
	nome_usuario VARCHAR(20) NOT NULL,
	senha VARCHAR(20) NOT NULL,

	CONSTRAINT pk_usuario PRIMARY KEY (id)
);