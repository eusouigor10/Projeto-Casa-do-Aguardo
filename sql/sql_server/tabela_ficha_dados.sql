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