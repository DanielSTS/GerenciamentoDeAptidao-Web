create database ProjetoBD;
use ProjetoBD;
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
                        foreign key (matricula_professor) references ProjetoBD.professor(matricula) on delete cascade);
                        
create table ProjetoBD.aluno (matricula  integer primary key,
			curso varchar(100),
			nome varchar(100),
            sexo varchar(100));

create table ProjetoBD.aluno_disciplina(codigo_a integer,
			codigo_d integer,
                        foreign key (codigo_a) references ProjetoBD.aluno(matricula) on delete cascade,
			foreign key (codigo_d) references ProjetoBD.disciplina(codigo) on delete cascade) ;

create table ProjetoBD.aula (numero integer,
			assunto varchar(100),
			material varchar(100),
			codigo_d integer ,
            primary key (numero,codigo_d),
			foreign key(codigo_d) references ProjetoBD.disciplina(codigo) on delete cascade);
                        
create table ProjetoBD.prova (assunto varchar(100),
			numero integer ,
			material varchar(100),
			codigo_d integer,
            primary key(numero,codigo_d),
			foreign key(codigo_d) references ProjetoBD.disciplina(codigo) on delete cascade);
                        
create table ProjetoBD.prova_aluno_disciplina (codigo_p integer,
						codigo_a integer,
                        codigo_d integer,
                        nota double precision,
                        primary key (codigo_p,codigo_a,codigo_d),
                        foreign key (codigo_p) references ProjetoBD.prova(numero) on delete cascade,
                        foreign key (codigo_a) references ProjetoBD.aluno(matricula) on delete cascade,
						foreign key (codigo_d) references ProjetoBD.disciplina(codigo) on delete cascade);
		


