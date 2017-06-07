select * from usuario

insert into usuario (Nome, Login, Senha, Gerente) values ('Jomar', 'jomar', '123456', 0)
update usuario
set Senha = '22217149fbeb7b991712fb94859b2d3e'
where id=1

insert into usuario (Nome, Login, Senha, Gerente) values ('Gerente', 'gerente', '123456', 1)
update usuario
set Senha = '3902c0df5d25ffb8106b777c84f207b4'
where id=2

select * from Produto

insert into produto (nome, valor, descricao) values ('Casamento 1', 1000, 'chique demais 1')
insert into produto (nome, valor, descricao) values ('Casamento 2', 2000, 'chique demais 2')
insert into produto (nome, valor, descricao) values ('Casamento 3', 3000, 'chique demais 3')
insert into produto (nome, valor, descricao) values ('Debutante 1', 1000, 'chique demais 1')
insert into produto (nome, valor, descricao) values ('Debutante 2', 2000, 'chique demais 2')
insert into produto (nome, valor, descricao) values ('Debutante 3', 3000, 'chique demais 3')
insert into produto (nome, valor, descricao) values ('Debutante 4', 4000, 'chique demais 4')
insert into produto (nome, valor, descricao) values ('Debutante 5', 5000, 'chique demais 5')
insert into produto (nome, valor, descricao) values ('Formatura 1', 1000, 'chique demais 1')
insert into produto (nome, valor, descricao) values ('Formatura 2', 2000, 'chique demais 2')
insert into produto (nome, valor, descricao) values ('Formatura 3', 3000, 'chique demais 3')
insert into produto (nome, valor, descricao) values ('Formatura 4', 4000, 'chique demais 4')
insert into produto (nome, valor, descricao) values ('Formatura 5', 5000, 'chique demais 5')

select * from opcional
insert into produto (nome, valor, descricao) values ('Cama Elástica', 300, 'chique demais 1')
insert into produto (nome, valor, descricao) values ('Churrasqueira Controle Remoto', 2000, 'chique demais 2')
insert into produto (nome, valor, descricao) values ('Dançarinos de Tango', 800, 'chique demais 3')
insert into produto (nome, valor, descricao) values ('Fotografo', 900, 'chique demais 1')
insert into produto (nome, valor, descricao) values ('Garçons', 2200, 'chique demais 2')
insert into produto (nome, valor, descricao) values ('Imitador', 500, 'chique demais 3')
insert into produto (nome, valor, descricao) values ('Palhaço', 600, 'chique demais 4')
insert into produto (nome, valor, descricao) values ('Pirotecnico', 1300, 'chique demais 5')
insert into produto (nome, valor, descricao) values ('Decoração', 3300, 'chique demais 1')

