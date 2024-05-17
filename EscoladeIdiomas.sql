drop database EscoladeIdiomas;
create database EscoladeIdiomas;

use EscoladeIdiomas;

-- Tabela de Professores
create table Professores (
  id int unique primary key,
  nome varchar(100) not null,
  email varchar(100) unique not null,
  senha varchar(100) not null
);

-- Tabela de Cursos
create table Cursos (
  id int unique primary key,
  nome varchar(100) not null,
  descricao varchar(100),
  preco decimal(8, 2) not null
);

-- Tabela de Aulas
create table Aulas (
  id int primary key,
  curso_id int,
  professor_id int,
  data_hora datetime,
  conteudo varchar(100),
  foreign key (curso_id) references Cursos(id),
  foreign key (professor_id) references Professores(id)
);

-- Tabela de Alunos
create table Alunos (
  id int unique primary key,
  nome varchar(100) not null,
  email varchar(100) unique not null,
--  aula_id int,
 -- notas_id int,
  senha varchar(100) not null
 -- foreign key (aula_id) references Aulas(id)
);

-- Tabela de Matrículas
create table Matriculas (
  id int primary key,
  aluno_id int,
  curso_id int,
  data_matricula date,
  foreign key (aluno_id) references Alunos(id),
  foreign key (curso_id) references Cursos(id)
);

-- Tabela de notas
create table Notas (
  id int primary key,
  aluno_id int,
  curso_id int,
  nota decimal(5, 2),
  foreign key (aluno_id) references Alunos(id),
  foreign key (curso_id) references Cursos(id)
);

-- Tabela de Tarefas
create table Tarefas (
  id int primary key,
  aula_id int,
  descricao varchar(100),
  foreign key (aula_id) references Aulas(id)
);

-- Tabela de Pagamentos
create table Pagamentos (
  id int primary key,
  aluno_id int,
  curso_id int,
  valor decimal(8, 2),
  data_pagamento date,
  foreign key (aluno_id) references Alunos(id),
  foreign key (curso_id) references Cursos(id)
);

-- Tabela de Certificados
create table Certificados (
  id int primary key,
  aluno_id int,
  curso_id int,
  data_conclusao date,
  foreign key (aluno_id) references Alunos(id),
  foreign key (curso_id) references Cursos(id)
);	

Insert into Professores (id, nome, email, senha)
values
  (1, 'Julio', 'julio@example.com','1111'),
  (2, 'Laura', 'laura@example.com','2222'),
  (3, 'Paulo', 'paulo@example.com','3333');
select* from Professores;

Insert into Cursos (id, nome, descricao, preco)
values
  (1, 'Inglês', 'Curso iniciante na lingua inglesa','2000'),
  (2, 'Espanhol', 'Curso iniciante na lingua espanhola','2300'),
  (3, 'Francês', 'Curso iniciante na lingua francesa','2500');
  select* from Cursos;

Insert into Aulas (id, curso_id, professor_id, data_hora, conteudo)
values
  (1, '1', '1','2023-05-24 10:00:00', 'aula 1/10'),
  (2, '2', '2','2023-05-24 11:00:00', 'aula 3/10'),
  (3, '3', '3','2023-05-24 08:00:00', 'aula 5/10');
  select* from Aulas;

Insert into Alunos (id, nome, email, senha)
values
  (1, 'João', 'joao@example.com','1122'),
  (2, 'Maria', 'maria@example.com','2233'),
  (3, 'Pedro', 'pedro@example.com','3344');
select* from Alunos;

Insert into Matriculas (id, aluno_id, curso_id, data_matricula)
values
  (1, '1', '1','2023-05-24 08:00:00'),
  (2, '2', '2','2023-05-21 08:00:00'),
  (3, '3', '3','2023-05-19 08:00:00');
select* from Matriculas;

Insert into Notas (id, aluno_id, curso_id, nota)
values
  (1, '1', '1','10'),
  (2, '2', '2','9'),
  (3, '3', '3','8');
select* from Notas;

Insert into Tarefas (id, aula_id, descricao)
values
  (1, '1', 'Fazer exercicio do 1 ao 10'),
  (2, '2', 'Fazer apresentação de si'),
  (3, '3','Fazer redação');
select* from Tarefas;

Insert into Pagamentos (id, aluno_id, curso_id, valor, data_pagamento)
values
  (1, '1', '1','1000','2023-05-20 08:00:00'),
  (2, '2', '2','2000','2023-05-20 08:00:00'),
  (3, '3', '3','1500','2023-05-19 08:00:00');
select* from Pagamentos;

Insert into Certificados (id, aluno_id, curso_id, data_conclusao)
values
  (1, '1', '1','2023-06-03 08:00:00'),
  (2, '2', '2','2023-05-30 08:00:00'),
  (3, '3', '3','2023-05-29 08:00:00');
select* from Certificados;

-- indice
create index idx_nome_alunos ON Alunos (nome);
select * from Alunos where nome = 'Pedro';

-- between datas de certificados/conclusões dos cursos em maio
select *from Certificados
where data_conclusao between '2023-05-01' AND '2023-05-30';

-- view notas gerais alunos por curso
CREATE VIEW View_NotasGerais AS
SELECT A.nome, C.nome as 'Curso', N.curso_id as 'Id do curso', N.nota
FROM Alunos A
INNER JOIN Notas N ON A.id = N.aluno_id
inner join Cursos C on C.id = N.curso_id;
select*from View_NotasGerais;