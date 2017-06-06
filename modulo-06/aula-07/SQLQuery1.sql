insert into Permissoes (Nome) values ('Colaborador')
insert into Permissoes (Nome) values ('Revisor')

insert into Colaboradores (Nome, Email, Senha) values ('Jomar Colaborador', 'jomar@cwi.com.br', '123456')
insert into Colaboradores (Nome, Email, Senha) values ('Jomar Colaborador', 'jomar@cwi.com.br', 'e2c12a6781130b50966a142abcdfb1a2')
insert into Colaboradores (Nome, Email, Senha, PermissaoColaborador_Id) values ('Jomar Revisor', 'jomarrevisor@cwi.com.br', 'e2c12a6781130b50966a142abcdfb1a2', 3)

insert into permissaoColaboradorColaboradors ( PermissaoColaborador_Id,	Colaborador_Id) values (1, 3)

select * from permissoesColaborador
select * from colaboradores
select * from colaboradorPermissao

select * from permissoescolaborador

delete from colaboradores 
where id = 5

select * from livros