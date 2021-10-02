# Desenvolvimento de Software para Web
 * [Sobre](#About)
 * [Configurações](#Configurações)
 * [Funcionalidades](#Funcionalidades)
 * [Requisitos](#Requisitos)
 
### About
 
Projeto 1 de Web, disciplina ministrada pelo professor Delano.

Implementação por:
  - Anderson Henrique Giacomini, 769720
  - Jean Araujo, 620394
  - Luciana Oliveira de Souza Gomes, 743569
  
### Configurações 

1- Baixe e configure o MySQL e o Tomcat no seu computador, conforme demonstrado nas aulas. 

2- Para configurar o banco de dados, execute o seguinte comando no MySQL:

```sql 

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
	ano int(4),
	mes int(2),
	dia int(2), 
	primary key (id)
	);

create table SistemaAgendamento.PROFISSIONAIS(
	id bigint not null auto_increment,
	cpf varchar(11) not null unique,
	email varchar(128) not null,
	senha varchar(64) not null, 
	nome varchar(128) not null,
	area varchar(128) not null,
	especialidade varchar(128) not null,
	primary key (id)
    );

create table SistemaAgendamento.CONSULTAS(
	id bigint not null auto_increment,

	id_C bigint not null,
	constraint CLIENTES_fk foreign  key (id_C) references CLIENTES(id),

	id_P bigint not null,
	constraint PROFISSIONAIS_fk foreign  key (id_P) references PROFISSIONAIS(id),

	ano int not null,
	mes int not null,
	dia int not null, 
	hora int not null,
	primary key (id),
	CONSTRAINT CH_Contulta CHECK (ano>=2000 and ano <=3000 AND mes >= 1 AND mes <= 12 and dia >= 1 and dia <= 31)
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

insert into SistemaAgendamento.CONSULTAS(id_C, id_P, ano, mes, dia, hora)
	values (1, 2, 2021, 10, 2, 14);

insert into SistemaAgendamento.CONSULTAS(id_C, id_P, ano, mes, dia, hora)
	values (2, 3, 2021, 9, 7, 11);

insert into SistemaAgendamento.CONSULTAS(id_C, id_P, ano, mes, dia, hora)
	values (3, 1, 2021, 12, 3, 10);
 
 ```
 
 3- Certifique-se que o login e senha de conexão do banco de dados no AcessaBD.java está igual ao que você configurou. 
 
 4- Faça o deploy do projeto usando o comando a seguir
 
 ```
 mvn clean package tomcat7:redeploy
 ```
 
 5- Acesse http://localhost:8080 e, utilizando o manager, acesse "SistemaAgendamento"
 
 ### Funcionalidades
 
 Para testar as funcionalidades do sistema:
 
 1- Na tela inicial já é exibida uma tabela com todos profissionais cadastrados, logo abaixo, há um campo que possibilita filtrar os funcionários pela área de atuação.
 
 2- Também na tela inicial há um botão "Login" que leva para a tela de autentificação de usuário. Para acessar como administrador, utilize login e senha "admin", na tela
de administrador é exibido uma tabela de clientes e uma de profissionais, e nessa tela concede acesso aos seus respectivos CRUDs.

 3- Após testar os CRUDs, volte para a tela de login e faça login como cliente ou como funcionário (utilize login: "agiacomini@estudante.ufscar.br", senha: "1234").
 
 4- Na tela de cliente é possivel agendar uma consulta
 
 ### Requisitos
 
 - R1: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
Pode ser acessado logando como: "admin","admin","Admin"
Faltou corrigir alguns bugs
- R2: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
Pode ser acessado logando como: "admin","admin","Admin"
Faltou corrigir alguns bugs
- R3: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
Faltou apenas o filtro por especialidade
- R4: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
Faltou apenas o envio dos emails
- R5: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
- R6: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
- R7: (X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
- R8: ( ) Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: igualmente dividido
Faltou apenas a aplicação nos .jsp