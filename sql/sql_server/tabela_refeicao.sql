CREATE TABLE Refeicao(
	id_refeicao INT,
	data_refeicao DATE,
	tipo VARCHAR(10),
	quantidade INT,

	CONSTRAINT pk_refeicao PRIMARY KEY (id_refeicao)
);