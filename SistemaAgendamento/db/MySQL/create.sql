create database AgendamentoConsultas;

use AgendamentoConsultas;

create table CLIENTES(
	cpf decimal(11) not null,
	email varchar(128) not null,
	senha varchar(128) not null, 
	nome varchar(256) not null,
	telefone varchar(13),
	sexo char(2),
	nascimento date,
	primary key (cpf)
	);

create table PROFISSIONAIS(
	cpf decimal(11) not null,
	email varchar(128) not null,
	senha varchar(64) not null, 
	nome varchar(128) not null,
	area varchar(128) not null,
	especialidade varchar(128) not null,
	primary key (cpf)
    );

create table CONSULTAS(
	id bigint not null auto_increment,

	cpf_C decimal(11) not null,  
	constraint CLIENTES_fk foreign  key (cpf_C) references CLIENTES(cpf),

	cpf_P decimal(11) not null,  
	constraint PROFISSIONAIS_fk foreign  key (cpf_P) references PROFISSIONAIS(cpf),

	agendamento datetime, 
    primary key (id)
	);

insert into CLIENTES(cpf, email, senha, nome) 
	values  ('11122233344', 'luciana.souza@estudante.ufscar.br', '1234', 'Luciana Souza');

insert into CLIENTES(cpf, email, senha, nome) 
	values  ('22233344455', 'jean.araujo@estudante.ufscar.br', '1234', 'Jean Araujo');

insert into CLIENTES(cpf, email, senha, nome) 
	values  ('33344455566', 'agiacomini@estudante.ufscar.br', '1234', 'Anderson Henrique');

insert into PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('11122233344', 'luciana.souza@estudante.ufscar.br', '1234', 'Luciana Souza', 'medicina', 'médica cardiologista');

insert into PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('22233344455', 'jean.araujo@estudante.ufscar.br', '1234', 'Jean Araujo', 'direito', 'advogado criminal');

insert into PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('33344455566', 'agiacomini@estudante.ufscar.br', '1234', 'Anderson Henrique', 'psicologia', 'psicólogo infantil');

insert into CONSULTAS(cpf_C, cpf_P, agendamento)
	values ('11122233344', '22233344455', '2021-10-10 10:00:00');

insert into CONSULTAS(cpf_C, cpf_P, agendamento)
	values ('22233344455', '33344455566', '2021-10-11 11:00:00');

insert into CONSULTAS(cpf_C, cpf_P, agendamento)
	values ('22233344455', '11122233344', '2021-10-12 12:00:00');