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