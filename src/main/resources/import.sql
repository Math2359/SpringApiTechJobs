INSERT INTO Candidato(Email, Senha, Nome) VALUES('carlos@gmail.com', '123456', 'Carlos Alberto');
INSERT INTO Candidato(Email, Senha, Nome) VALUES('roberta@gmail.com', '123456', 'Roberta Alberta');

INSERT INTO Empresa(Email, Senha, Nome, Cnpj) VALUES('empresa@gmail.com', '123456', 'Empresa', '81652241000117');
INSERT INTO Empresa(Email, Senha, Nome, Cnpj) VALUES('instituto@gmail.com', '123456', 'Instituto Contrate', '42380158000184');

INSERT INTO Vaga(id_empresa, Cargo, Modelo, Nivel, Cep, Numero, Descricao, Salario) VALUES(1, 'Desenvolvedor', 'Híbrido', 'Sênior', '99999-999', '102', 'Vaga para pessoas com experiência', 10000.00);
INSERT INTO Vaga(id_empresa, Cargo, Modelo, Nivel, Cep, Numero, Descricao, Salario) VALUES(1, 'Analista', 'Híbrido', 'Júnior', '99999-999', '120', 'Vaga para pessoas pouca com experiência', 5000.00);
INSERT INTO Vaga(id_empresa, Cargo, Modelo, Nivel, Cep, Numero, Descricao, Salario) VALUES(2, 'Analista', 'Híbrido', 'Júnior', '09401-070', '111', 'Vaga para pessoas com pouca experiência', 5000.00);
INSERT INTO Vaga(id_empresa, Cargo, Modelo, Nivel, Cep, Numero, Descricao, Salario) VALUES(2, 'Desenvolvedor', 'Híbrido', 'Sênior', '09401-070', '111', 'Vaga para pessoas com experiência', 10000.00);
