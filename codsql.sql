create database ProjetoBD;

create table ProjetoBD.professor (matricula integer primary key,
						email varchar(100),
						datanascimento varchar(100),
                        nome varchar(100),
                        areadeformacao varchar(100),
                        titulacao varchar(100),
                        sexo varchar(100),
                        senha varchar(100));
			

create table ProjetoBD.disciplina (codigo integer  primary key,
						nome varchar(100),matricula_professor integer,
                        foreign key (matricula_professor) references ProjetoBD.professor(matricula));
                        


create table ProjetoBD.aluno_disciplina(codigo_a integer,
						 codigo_d integer,
                         foreign key (codigo_a) references ProjetoBD.aluno(matricula),
						 foreign key (codigo_d) references ProjetoBD.disciplina(codigo));

create table ProjetoBD.aula (numero integer primary key,
						assunto varchar(100),
                        material varchar(100),
                        codigo_d integer,
                        foreign key(codigo_d) references ProjetoBD.disciplina(codigo));
                        
create table ProjetoBD.prova (assunto varchar(100),
						numero integer primary key,
						matricula_professor integer,
                        codigo_d integer,
                        foreign key(codigo_d)references ProjetoBD.disciplina(codigo));

create table ProjetoBD.aluno (matricula integer primary key,
						curso varchar(100),
                        nome varchar(100));
                        
create table ProjetoBD.prova_aluno (codigo_p integer,
						codigo_a integer,
                        nota double precision,
                        foreign key (codigo_p) references ProjetoBD.prova(numero),
                        foreign key (codigo_a) references ProjetoBD.aluno(matricula));
		
select * from ProjetoBD.disciplina;
select * from ProjetoBD.professor;
select * from ProjetoBD.aluno;
select * from ProjetoBD.professor_disciplina

insert into ProjetoBD.disciplina VALUES (13,'matematica')

alter table ProjetoBD.disciplina add matricula_professor integer


