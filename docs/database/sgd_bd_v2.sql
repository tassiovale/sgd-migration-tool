
CREATE TABLE nivel_classe (
                id_nivel_classe INTEGER NOT NULL,
                nivel_classe VARCHAR NOT NULL,
                CONSTRAINT id_nivel_classe PRIMARY KEY (id_nivel_classe)
);


CREATE TABLE classe_docente (
                id_classe_docente INTEGER NOT NULL,
                classe_docente VARCHAR NOT NULL,
                CONSTRAINT id_classe_docente PRIMARY KEY (id_classe_docente)
);


CREATE TABLE origem_vaga (
                id_origem_vaga INTEGER NOT NULL,
                origem_vaga VARCHAR NOT NULL,
                CONSTRAINT id_origem_vaga PRIMARY KEY (id_origem_vaga)
);


CREATE TABLE carga_horaria (
                id_carga_horaria INTEGER NOT NULL,
                carga_horaria REAL NOT NULL,
                CONSTRAINT id_carga_horaria PRIMARY KEY (id_carga_horaria)
);


CREATE TABLE sala (
                id_sala INTEGER NOT NULL,
                sala VARCHAR NOT NULL,
                local VARCHAR NOT NULL,
                CONSTRAINT id_sala PRIMARY KEY (id_sala)
);
COMMENT ON COLUMN sala.sala IS 'informações da sala';


CREATE TABLE titulacao (
                id_titulacao INTEGER NOT NULL,
                nome_titulacao VARCHAR NOT NULL,
                CONSTRAINT id_titulacao PRIMARY KEY (id_titulacao)
);


CREATE TABLE area_conhecimento (
                id_area INTEGER NOT NULL,
                nome_area VARCHAR NOT NULL,
                CONSTRAINT id_area PRIMARY KEY (id_area)
);


CREATE TABLE disciplina (
                id_disciplina INTEGER NOT NULL,
                nome_disciplina INTEGER NOT NULL,
                local_disciplina VARCHAR NOT NULL,
                CONSTRAINT id_disciplina PRIMARY KEY (id_disciplina)
);


CREATE TABLE usuario (
                siape INTEGER NOT NULL,
                email VARCHAR(20) NOT NULL,
                senha VARCHAR NOT NULL,
                ativo BOOLEAN DEFAULT true NOT NULL,
                CONSTRAINT siape PRIMARY KEY (siape)
);
COMMENT ON COLUMN usuario.siape IS 'siape tem 7 digitos.';


CREATE TABLE docente (
                siape INTEGER NOT NULL,
                id_titulacao INTEGER NOT NULL,
                nome VARCHAR(45) NOT NULL,
                telefone1 VARCHAR(15) NOT NULL,
                telefone2 VARCHAR(15),
                data_ingresso DATE NOT NULL,
                id_origem_vaga INTEGER NOT NULL,
                id_nivel_classe INTEGER NOT NULL,
                id_carga_horaria INTEGER NOT NULL,
                id_classe_docente INTEGER NOT NULL,
                id_area INTEGER NOT NULL,
                CONSTRAINT siape PRIMARY KEY (siape)
);


CREATE TABLE cargo (
                id_cargo INTEGER NOT NULL,
                nome_cargo VARCHAR NOT NULL,
                siape INTEGER NOT NULL,
                CONSTRAINT id_cargo PRIMARY KEY (id_cargo)
);


CREATE TABLE controle_rad (
                id_controle_rad INTEGER NOT NULL,
                data_entrega DATE NOT NULL,
                data_envio DATE NOT NULL,
                data_envio_coordenador DATE NOT NULL,
                siape INTEGER NOT NULL,
                CONSTRAINT id_controle_rad PRIMARY KEY (id_controle_rad)
);


CREATE TABLE controle_rit (
                id_controle_rit INTEGER NOT NULL,
                data_entrega DATE NOT NULL,
                siape INTEGER NOT NULL,
                CONSTRAINT id_controle_rit PRIMARY KEY (id_controle_rit)
);


CREATE TABLE controle_pit (
                id_controle_pit INTEGER NOT NULL,
                data_entrega DATE NOT NULL,
                siape INTEGER NOT NULL,
                CONSTRAINT id_controle_pit PRIMARY KEY (id_controle_pit)
);


CREATE TABLE docente_disciplina (
                id_disciplina INTEGER NOT NULL,
                siape INTEGER NOT NULL,
                CONSTRAINT siape PRIMARY KEY (id_disciplina, siape)
);
COMMENT ON TABLE docente_disciplina IS 'tabela intermediária para o relacionamento entre docente e displina.';


CREATE TABLE sala_docente (
                siape INTEGER NOT NULL,
                id_sala INTEGER NOT NULL,
                CONSTRAINT siape PRIMARY KEY (siape, id_sala)
);
COMMENT ON TABLE sala_docente IS 'tabela de intermediária  relacionamento entre sala e docente.';


ALTER TABLE docente ADD CONSTRAINT nivel_classe_docente_fk
FOREIGN KEY (id_nivel_classe)
REFERENCES nivel_classe (id_nivel_classe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT classe_docente_docente_fk
FOREIGN KEY (id_classe_docente)
REFERENCES classe_docente (id_classe_docente)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT origem_vaga_docente_fk
FOREIGN KEY (id_origem_vaga)
REFERENCES origem_vaga (id_origem_vaga)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT carga_horaria_docente_fk
FOREIGN KEY (id_carga_horaria)
REFERENCES carga_horaria (id_carga_horaria)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sala_docente ADD CONSTRAINT sala_sala_docente_fk
FOREIGN KEY (id_sala)
REFERENCES sala (id_sala)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT titulacao_docente_fk
FOREIGN KEY (id_titulacao)
REFERENCES titulacao (id_titulacao)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT area_conhecimento_docente_fk
FOREIGN KEY (id_area)
REFERENCES area_conhecimento (id_area)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente_disciplina ADD CONSTRAINT disciplina_docente_disciplina_fk
FOREIGN KEY (id_disciplina)
REFERENCES disciplina (id_disciplina)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente ADD CONSTRAINT usuario_docente_fk
FOREIGN KEY (siape)
REFERENCES usuario (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE sala_docente ADD CONSTRAINT docente_sala_docente_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE docente_disciplina ADD CONSTRAINT docente_docente_disciplina_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE controle_pit ADD CONSTRAINT docente_controle_pit_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE controle_rit ADD CONSTRAINT docente_controle_rit_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE controle_rad ADD CONSTRAINT docente_controle_rad_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE cargo ADD CONSTRAINT docente_cargo_fk
FOREIGN KEY (siape)
REFERENCES docente (siape)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
