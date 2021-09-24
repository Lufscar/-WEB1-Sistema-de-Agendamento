drop schema SistemaAgendamento;

create database SistemaAgendamento;

use SistemaAgendamento;

create table SistemaAgendamento.CLIENTES(
	id bigint not null auto_increment,
	cpf varchar(11) not null unique,
	email varchar(128) not null,
	senha varchar(64) not null, 
	nome varchar(128) not null,
	telefone varchar(13),
	sexo char(2),
	nascimento date,
	primary key (id, cpf)
	);

create table SistemaAgendamento.PROFISSIONAIS(
	id bigint not null auto_increment,
	cpf varchar(11) not null unique,
	email varchar(128) not null,
	senha varchar(64) not null, 
	nome varchar(128) not null,
	area varchar(128) not null,
	especialidade varchar(128) not null,
	primary key (id, cpf)
    );

create table SistemaAgendamento.CONSULTAS(
	id bigint not null auto_increment,

	id_C bigint not null,
	cpf_C varchar(11) not null,  
	constraint CLIENTES_fk foreign  key (id_C, cpf_C) references CLIENTES(id, cpf),

	id_P bigint not null,
	cpf_P varchar(11) not null,  
	constraint PROFISSIONAIS_fk foreign  key (id_P, cpf_P) references PROFISSIONAIS(id, cpf),

	agendamento datetime, 
    primary key (id)
	);

insert into SistemaAgendamento.CLIENTES(cpf, email, senha, nome) 
	values  ('11122233344', 'luciana.souza@estudante.ufscar.br', '1234', 'Luciana Souza');

insert into SistemaAgendamento.CLIENTES(cpf, email, senha, nome) 
	values  ('22233344455', 'jean.araujo@estudante.ufscar.br', '1234', 'Jean Araujo');

insert into SistemaAgendamento.CLIENTES(cpf, email, senha, nome) 
	values  ('33344455566', 'agiacomini@estudante.ufscar.br', '1234', 'Anderson Henrique');

insert into SistemaAgendamento.PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('11122233344', 'luciana.souza@estudante.ufscar.br', '1234', 'Luciana Souza', 'medicina', 'médica cardiologista');

insert into SistemaAgendamento.PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('22233344455', 'jean.araujo@estudante.ufscar.br', '1234', 'Jean Araujo', 'direito', 'advogado criminal');

insert into SistemaAgendamento.PROFISSIONAIS(cpf, email, senha, nome, area, especialidade) 
	values  ('33344455566', 'agiacomini@estudante.ufscar.br', '1234', 'Anderson Henrique', 'psicologia', 'psicólogo infantil');

insert into SistemaAgendamento.CONSULTAS(id_C, cpf_C, id_P, cpf_P, agendamento)
	values (1, '11122233344', 2, '22233344455', '2021-10-10 10:00:00');

insert into SistemaAgendamento.CONSULTAS(id_C, cpf_C, id_P, cpf_P, agendamento)
	values (2, '22233344455', 3,'33344455566', '2021-10-11 11:00:00');

insert into SistemaAgendamento.CONSULTAS(id_C, cpf_C, id_P, cpf_P, agendamento)
	values (3, '33344455566', 1, '11122233344', '2021-10-12 12:00:00');