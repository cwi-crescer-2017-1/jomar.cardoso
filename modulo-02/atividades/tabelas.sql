Create table Cidade 
(
  IDCidade  int         not null,
  Nome      varchar(30) not null,
  UF        varchar(2)  not null,
    constraint PK_Cidade primary key (IDCidade)
);	

Create table Associado 
(
  IDAssociado    int         not null,
  Nome           varchar(50) not null,
  DataNascimento datetime    not null,
  Sexo           char(1)     not null,
  CPF            varchar(11) ,
  Endereco       varchar(35),
  Bairro         varchar(25),
  Complemento    varchar(20),
  IDCidade       int,
     constraint PK_Associado primary key (IDAssociado),
	 constraint FK_Associado foreign key (IDCidade)
	    references Cidade (IDCidade)
);

insert into Cidade (IDCidade, Nome, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (2, 'Porto Alegre', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (3, 'Parobe', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (4, 'Taquara', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (105, 'S�o Paulo', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (106, 'Guarulhos', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (108, 'Brasilia', 'DF');
insert into Cidade (IDCidade, Nome, UF)
   values (109, 'Belo Horizonte', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (110, 'Uberl�ndia', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (5, 'Cidade de Alagoas', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (6, 'Maceio', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (7, 'Itu', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (8, 'Campinas', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (9, 'Guaratingueta', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (10, 'Santa Barbara', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (11, 'Campos dos Goitacases', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (12, 'Sao Gabriel', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (13, 'Brasopolis', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (14, 'Cristina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (15, 'Umbuzeiro', 'PB');
insert into Cidade (IDCidade, Nome, UF)
   values (16, 'Vicosa', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (17, 'Macae', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (18, 'Sao Luis', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (19, 'Cuiaba', 'MT');
insert into Cidade (IDCidade, Nome, UF)
   values (20, 'Sao Borja', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (21, 'Natal', 'RN');
insert into Cidade (IDCidade, Nome, UF)
   values (22, 'Diamantina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (23, 'Campo Grande', 'MS');
insert into Cidade (IDCidade, Nome, UF)
   values (24, 'Fortaleza', 'CE');
insert into Cidade (IDCidade, Nome, UF)
   values (25, 'Bage', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (26, 'Bento Goncalves', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (28, 'Pinheiro', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (29, 'Salvador', 'BA');
insert into Cidade (IDCidade, Nome, UF)
   values (30, 'Garanhuns', 'PE');
Insert into Cidade (IDCidade, Nome, UF)
   values (31, 'S�o Paulo', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (32, 'Guarulhos', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (33, 'Rio de Janeiro', 'RJ');    
Insert into Cidade (IDCidade, Nome, UF)
   values (34, 'Brasilia', 'DF');    
Insert into Cidade (IDCidade, Nome, UF)
   values (35, 'Belo Horizonte', 'MG');        
Insert into Cidade (IDCidade, Nome, UF)
   values  (36, 'Uberl�ndia', 'MG');      
Insert into Cidade (IDCidade, Nome, UF)
   values  (37, 'Santana do Livramento', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (38, 'Santa Maria', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (39, 'Santa Rosa', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (40, 'S�o Francisco de Paula', 'RS');  
   
   -- ASSOCIADOS...
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values 
      (1, 
       'Ana Paula Padrao', 
       convert(datetime, '10/05/1980', 103), 
       'F' );
--
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values  
      (2, 
       'Joao Soares', 
       convert(datetime, '20/02/1980', 103), 
       'M' );  

	   create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Opera��es', 'RECIFE');
insert into Departamento values (1, 'Presid�ncia', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);

update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

alter table empregado add DataNascimento date;

begin transaction
go

update Empregado set DataNascimento = convert(date, '22/12/1962', 103) where idEmpregado = 	7369;
update Empregado set DataNascimento = convert(date, '25/02/1961', 103) where idEmpregado = 	7499;
update Empregado set DataNascimento = convert(date, '27/02/1962', 103) where idEmpregado = 	7521;
update Empregado set DataNascimento = convert(date, '09/04/1952', 103) where idEmpregado = 	7566;
update Empregado set DataNascimento = convert(date, '06/10/1950', 103) where idEmpregado = 	7654;
update Empregado set DataNascimento = convert(date, '07/05/1959', 103) where idEmpregado = 	7698;
update Empregado set DataNascimento = convert(date, '15/06/1956', 103) where idEmpregado = 	7782;
update Empregado set DataNascimento = convert(date, '13/12/1966', 103) where idEmpregado = 	7788;
update Empregado set DataNascimento = convert(date, '22/11/1961', 103) where idEmpregado = 	7839;
update Empregado set DataNascimento = convert(date, '15/09/1954', 103) where idEmpregado = 	7844;
update Empregado set DataNascimento = convert(date, '22/01/1944', 103) where idEmpregado = 	7876;
update Empregado set DataNascimento = convert(date, '10/12/1955', 103) where idEmpregado = 	7900;
update Empregado set DataNascimento = convert(date, '09/12/1957', 103) where idEmpregado = 	7902;
update Empregado set DataNascimento = convert(date, '30/01/1955', 103) where idEmpregado = 	7934;
update Empregado set DataNascimento = convert(date, '24/01/1969', 103) where idEmpregado = 	7940;

commit
go

insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ABC-3401', 'branco', 'fiat', 'palio', 'carlos da silva', 'carlos.silva@company.com', '9987-0102');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('ITR-1304', 'preto', 'citroen', 'C4', 'maria ribeiro', 'maria.ribeiro@company.com', '9764-1325');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('IAB-0101', 'preto', 'honda', 'civic', 'julia de souza', 'julia.souza@company.com', '9660-0669');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('MMA-9876', 'prata', 'fiat', 'siena', 'antonio silveira', 'antonio.silveira@company.com', '9495-2597');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('JIR-4576', 'branco', 'volkswagem', 'gol', 'pedro paulo de almeida', 'pedro.almeida@company.com', '8446-1332');
insert into carro (placa, cor, marca, modelo, proprietario, email, telefone) values ('POT-0660', 'amarelo', 'chevrolet', 'monza', 'alfredo silveira da silva', 'alfredo.silva@company.com', '8669-0909');


/*
  Cria��o da tabela com dados FICT�CIOS de licita��es para obras p�blicas
  
*/
CREATE TABLE  Licitacao      (
	Identificador               int       NOT NULL,
	Projeto                     varchar(255) not null,
	Situacao                    varchar(255) not null,
	Solicitante                 varchar(255) not null,
	Esfera                      varchar(255) not null,
	Municipio                   varchar(255) not null,
	Estado                      varchar(2)   not null,
	Valor_Previsto              float        not null,
	Valor_Realizado             float        not null,
	Imposto_Federal             float        not null,
	Imposto_Estadual            float        not null,
	Imposto_Municipal           float        not null,
	Profissionais               float        not null,
	Data_Inicio_Prev            datetime     not null,
	Data_Inicio_Real            datetime     not null,
	Data_Fim_Prev               datetime     not null,
	Data_Fim_Real               datetime     not null,
	Empresa_Licitante           varchar(255) not null,
	Faturamento_1Ano_Anterior   float not null,
	Faturamento_2Ano_Anterior   float not null,
	Numero_Concorrentes         float not null,
	Lance_2Colocado             float not null,
	   constraint PK_Licitacao primary key (Identificador)
)
go

INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10100, N'Sala de Testemunhas', N'Normal', N'STF', N'Federal', N'Brasilia', N'DF', 2350000.7, 2350000.7, 658000.19600000011, 293750.0875, 159800.04760000002, 125, CAST(N'2016-01-02 00:00:00.000' AS DateTime), CAST(N'2016-01-21 00:00:00.000' AS DateTime), CAST(N'2017-07-25 00:00:00.000' AS DateTime), CAST(N'2017-09-28 00:00:00.000' AS DateTime), N'Empreiteira Cedilha', 21396019.08, 18186616.218, 10, 2622600.781200001)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10235, N'Pra�a Primeiro de Maio', N'Normal', N'Secretaria de Cultura', N'Municipal', N'Campinas', N'SP', 249125.2, 249125.2, 77228.812, 31140.65, 24406.2975936, 32, CAST(N'2016-01-05 00:00:00.000' AS DateTime), CAST(N'2016-01-20 00:00:00.000' AS DateTime), CAST(N'2016-06-03 00:00:00.000' AS DateTime), CAST(N'2016-08-21 00:00:00.000' AS DateTime), N'Epsilon S.A.', 996500.8, 847025.68, 3, 303932.744)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10370, N'Posto de Sa�de 1', N'Normal', N'Secretaria da Saude', N'Municipal', N'Porto Alegre', N'RS', 780000, 780000, 335400, 195000, 53040.000000000007, 22, CAST(N'2016-01-10 00:00:00.000' AS DateTime), CAST(N'2016-02-14 00:00:00.000' AS DateTime), CAST(N'2017-02-03 00:00:00.000' AS DateTime), CAST(N'2017-02-18 00:00:00.000' AS DateTime), N'Construtora PROBEM', 15600000, 13260000, 4, 858000.00000000012)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10505, N'Posto de Sa�de 114', N'Normal', N'Secretaria da Saude', N'Municipal', N'Porto Alegre', N'RS', 60500, 60500, 22385, 13612.5, 4114, 22, CAST(N'2016-01-10 00:00:00.000' AS DateTime), CAST(N'2016-02-14 00:00:00.000' AS DateTime), CAST(N'2017-02-03 00:00:00.000' AS DateTime), CAST(N'2017-02-18 00:00:00.000' AS DateTime), N'Joao de Barro ME', 15600000, 13260000, 4, 834599.99999999988)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10640, N'Delegacia', N'Normal', N'Policia Militar', N'Estadual', N'S�o Borja', N'RS', 451277.12, 451277.12, 139444.63008, 112819.28, 30686.84416, 70, CAST(N'2016-02-15 00:00:00.000' AS DateTime), CAST(N'2016-02-15 00:00:00.000' AS DateTime), CAST(N'2017-07-09 00:00:00.000' AS DateTime), CAST(N'2018-07-24 00:00:00.000' AS DateTime), N'Grupo Alpha', 45012301.2, 38260456.02, 15, 4951353.132)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10775, N'Museu Dom Pedro II', N'Normal', N'Secretaria de Cultura', N'Municipal', N'S�o Paulo', N'SP', 140950.2, 140950.2, 50319.2214, 17618.775, 13643.97936, 34, CAST(N'2016-02-16 00:00:00.000' AS DateTime), CAST(N'2016-03-02 00:00:00.000' AS DateTime), CAST(N'2016-08-14 00:00:00.000' AS DateTime), CAST(N'2016-11-01 00:00:00.000' AS DateTime), N'Epsilon S.A.', 996500.8, 847025.68, 10, 303932.744)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (10910, N'Reforma da Sala de Imprensa', N'Normal', N'Camara dos Deputados', N'Federal', N'Brasilia', N'DF', 1010120.1, 1060626.105, 421220.0817, 126265.0125, 68688.1668, 85, CAST(N'2016-02-19 00:00:00.000' AS DateTime), CAST(N'2016-02-26 00:00:00.000' AS DateTime), CAST(N'2016-09-16 00:00:00.000' AS DateTime), CAST(N'2016-12-03 00:00:00.000' AS DateTime), N'Grupo Celta', 581100.2, 493935.16999999993, 17, 1313156.13)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11045, N'Reforma do Auditorio', N'Normal', N'Ministerio da Cultura', N'Federal', N'Rio de Janeiro', N'RJ', 1783250.7, 2175565.854, 731132.78699999989, 338817.633, 121261.0476, 136, CAST(N'2016-02-20 00:00:00.000' AS DateTime), CAST(N'2016-03-10 00:00:00.000' AS DateTime), CAST(N'2016-10-17 00:00:00.000' AS DateTime), CAST(N'2017-02-14 00:00:00.000' AS DateTime), N'Irm�os Valente Ltda', 1426600.56, 1212610.476, 2, 1925910.756)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11180, N'Reforma do Auditorio', N'Normal', N'Ministerio de Minas e Energia', N'Federal', N'Rio de Janeiro', N'RJ', 1032150.7, 1259223.8539999998, 175465.619, 185787.126, 173401.3176, 131, CAST(N'2016-02-20 00:00:00.000' AS DateTime), CAST(N'2016-03-10 00:00:00.000' AS DateTime), CAST(N'2016-09-17 00:00:00.000' AS DateTime), CAST(N'2017-05-15 00:00:00.000' AS DateTime), N'Irm�os Valente Ltda', 1426600.56, 1212610.476, 16, 1925910.756)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11315, N'Predio da Secretaria', N'Normal', N'Assembleia Legislativa', N'Estadual', N'Florianopolis', N'SC', 8901234.12, 9515419.2742799986, 3115431.9419999993, 1112654.265, 605283.92016, 400, CAST(N'2016-03-01 00:00:00.000' AS DateTime), CAST(N'2016-03-08 00:00:00.000' AS DateTime), CAST(N'2016-12-26 00:00:00.000' AS DateTime), CAST(N'2017-04-25 00:00:00.000' AS DateTime), N'ContruForte e Associados', 4450617.06, 3783024.501, 4, 9969382.2144)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11450, N'Reforma Sede', N'Normal', N'Camara Municipal', N'Municipal', N'Blumenau', N'SC', 800500.25, 855734.76725, 312195.09750000003, 148092.54625, 54434.017000000007, 320, CAST(N'2016-03-01 00:00:00.000' AS DateTime), CAST(N'2016-02-01 00:00:00.000' AS DateTime), CAST(N'2016-08-28 00:00:00.000' AS DateTime), CAST(N'2016-12-30 00:00:00.000' AS DateTime), N'ContruForte e Associados', 4450617.06, 3783024.501, 6, 896560.28)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11585, N'Aeroporto', N'Normal', N'Ministerio do Transporte', N'Federal', N'Guarulhos', N'SP', 8500314, 11730433.319999998, 3570131.88, 1351549.926, 578021.35200000007, 9, CAST(N'2016-03-01 00:00:00.000' AS DateTime), CAST(N'2016-03-08 00:00:00.000' AS DateTime), CAST(N'2017-06-24 00:00:00.000' AS DateTime), CAST(N'2017-08-07 00:00:00.000' AS DateTime), N'Upsilon Ltda', 4500940, 3825799, 8, 5041052.8000000007)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11720, N'Posto de Sa�de', N'Normal', N'Secretaria da Saude', N'Municipal', N'Caxias do Sul', N'RS', 76200, 76200, 28194, 13639.8, 8991.6, 19, CAST(N'2016-03-06 00:00:00.000' AS DateTime), CAST(N'2016-04-10 00:00:00.000' AS DateTime), CAST(N'2016-09-02 00:00:00.000' AS DateTime), CAST(N'2016-09-17 00:00:00.000' AS DateTime), N'Construtora PROBEM', 15600000, 13260000, 6, 858000.00000000012)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11855, N'Posto de Sa�de', N'Normal', N'Secretaria da Saude', N'Municipal', N'Porto Alegre', N'RS', 102500, 102500, 43050, 20397.5, 6970.0000000000009, 6, CAST(N'2016-03-10 00:00:00.000' AS DateTime), CAST(N'2016-04-14 00:00:00.000' AS DateTime), CAST(N'2017-10-01 00:00:00.000' AS DateTime), CAST(N'2017-10-16 00:00:00.000' AS DateTime), N'Joao de Barro ME', 15600000, 13260000, 13, 834599.99999999988)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (11990, N'Deposito Geral', N'Normal', N'Secretaria da Fazenda', N'Estadual', N'Americana', N'SP', 2866349.9, 2866349.9, 1060549.463, 358293.7375, 194911.7932, 130, CAST(N'2016-03-11 00:00:00.000' AS DateTime), CAST(N'2016-03-11 00:00:00.000' AS DateTime), CAST(N'2017-01-05 00:00:00.000' AS DateTime), CAST(N'2017-02-19 00:00:00.000' AS DateTime), N'ABC Construcoes', 2866349.9, 2436397.415, 8, 3439619.88)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12125, N'Reforma da Mesa Diretora', N'Normal', N'Camara dos Vereadores', N'Municipal', N'Belo Horizonte', N'MG', 129349.2, 129349.2, 51830.22444, 16168.65, 12676.2216, 45, CAST(N'2016-03-20 00:00:00.000' AS DateTime), CAST(N'2016-04-04 00:00:00.000' AS DateTime), CAST(N'2017-05-14 00:00:00.000' AS DateTime), CAST(N'2017-09-11 00:00:00.000' AS DateTime), N'Rocha Empreiteira', 232828.56, 197904.276, 5, 134523.168)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12260, N'Delegacia', N'Normal', N'Policia Civil', N'Estadual', N'Alegrete', N'RS', 665500.1, 665500.1, 210963.5317, 133100.02, 45254.0068, 34, CAST(N'2016-03-26 00:00:00.000' AS DateTime), CAST(N'2016-03-27 00:00:00.000' AS DateTime), CAST(N'2017-02-19 00:00:00.000' AS DateTime), CAST(N'2017-02-24 00:00:00.000' AS DateTime), N'Jose Construcoes', 863500.1, 733975.085, 20, 915310.106)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12395, N'Delegacia', N'Normal', N'Policia Militar', N'Estadual', N'Bage', N'RS', 4501230.12, 4501230.12, 1755479.7468, 787715.271, 306083.64816000004, 68, CAST(N'2016-03-27 00:00:00.000' AS DateTime), CAST(N'2016-03-27 00:00:00.000' AS DateTime), CAST(N'2017-03-22 00:00:00.000' AS DateTime), CAST(N'2018-04-06 00:00:00.000' AS DateTime), N'Grupo Alpha', 45012301.2, 38260456.02, 6, 4951353.132)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12530, N'Sala Presidente', N'Normal', N'Camara dos Vereadores', N'Municipal', N'Uberlandia', N'MG', 390500.75, 390500.75, 138237.26549999998, 48812.59375, 109340.21, 44, CAST(N'2016-03-28 00:00:00.000' AS DateTime), CAST(N'2016-04-12 00:00:00.000' AS DateTime), CAST(N'2016-11-23 00:00:00.000' AS DateTime), CAST(N'2016-12-23 00:00:00.000' AS DateTime), N'Rocha Empreiteira', 232828.56, 197904.276, 14, 425645.8175)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12665, N'Ginasio Municipal', N'Normal', N'Secretaria de Esporte', N'Municipal', N'Joinville', N'SC', 450600.7, 450600.7, 161315.0506, 56325.0875, 30640.847600000005, 40, CAST(N'2016-03-31 00:00:00.000' AS DateTime), CAST(N'2016-04-19 00:00:00.000' AS DateTime), CAST(N'2016-09-27 00:00:00.000' AS DateTime), CAST(N'2017-01-25 00:00:00.000' AS DateTime), N'ContruForte e Associados', 4450617.06, 3783024.501, 3, 473130.735)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12800, N'Predio Principal', N'Normal', N'Assembleia Legislativa', N'Estadual', N'Rio de Janeiro', N'RJ', 680500, 681724.9, 206191.5, 105477.5, 46274, 50, CAST(N'2016-04-09 00:00:00.000' AS DateTime), CAST(N'2016-04-09 00:00:00.000' AS DateTime), CAST(N'2017-01-04 00:00:00.000' AS DateTime), CAST(N'2017-04-09 00:00:00.000' AS DateTime), N'Construtora Maria & Marta', 15622032, 13278727.2, 13, 741745)
GO
INSERT [dbo].[Licitacao] ([Identificador], [fProjeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (12935, N'Predio Principal', N'Normal', N'Executivo', N'Estadual', N'Rio de Janeiro', N'RJ', 390550.8, 391253.79144, 132787.272, 76157.406, 26557.4544, 60, CAST(N'2016-04-09 00:00:00.000' AS DateTime), CAST(N'2016-04-09 00:00:00.000' AS DateTime), CAST(N'2016-07-08 00:00:00.000' AS DateTime), CAST(N'2016-10-11 00:00:00.000' AS DateTime), N'Construtora Maria & Marta', 15622032, 13278727.2, 4, 394456.30800000008)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13070, N'Auditorio', N'Normal', N'Camara dos Vereadores', N'Municipal', N'Mogi das Cruzes', N'SP', 98000, 98000, 42826, 12250, 6664.0000000000009, 18, CAST(N'2016-04-10 00:00:00.000' AS DateTime), CAST(N'2016-04-29 00:00:00.000' AS DateTime), CAST(N'2016-06-09 00:00:00.000' AS DateTime), CAST(N'2016-07-24 00:00:00.000' AS DateTime), N'Silva Construcoes', 98000, 83300, 6, 117600)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13205, N'Dep�sito de Ve�culos', N'Normal', N'Ministerio da Defesa', N'Federal', N'Americana', N'SP', 100900.4, 103927.412, 37333.147999999994, 12612.55, 6861.2272, 88, CAST(N'2016-04-22 00:00:00.000' AS DateTime), CAST(N'2016-04-22 00:00:00.000' AS DateTime), CAST(N'2017-01-17 00:00:00.000' AS DateTime), CAST(N'2017-11-14 00:00:00.000' AS DateTime), N'Sigma e PI Ltda', 2400901.74, 2040766.479, 5, 1380518.5005)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13340, N'Amplia��o da Cozinha', N'Normal', N'Senado', N'Federal', N'Brasilia', N'DF', 1783001.59, 1783001.59, 779171.69483, 222875.19875, 121244.10812000002, 120, CAST(N'2016-04-30 00:00:00.000' AS DateTime), CAST(N'2016-05-19 00:00:00.000' AS DateTime), CAST(N'2016-06-29 00:00:00.000' AS DateTime), CAST(N'2016-09-02 00:00:00.000' AS DateTime), N'Empreiteira Cedilha', 21396019.08, 18186616.218, 3, 2068281.8444000003)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13475, N'Ampliacao do Hospital', N'Normal', N'Ministerio da Saude', N'Federal', N'Gramado', N'RS', 315800, 318326.4, 135794, 61581, 21474.4, 80, CAST(N'2016-04-30 00:00:00.000' AS DateTime), CAST(N'2016-05-01 00:00:00.000' AS DateTime), CAST(N'2016-12-26 00:00:00.000' AS DateTime), CAST(N'2017-02-24 00:00:00.000' AS DateTime), N'Pedro Pedreiro Ltda', 230400000, 195840000, 6, 344221.99999999994)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13610, N'Ampliacao do Hospital', N'Normal', N'Ministerio da Saude', N'Federal', N'Passo Fundo', N'RS', 487500, 491400, 151125, 82875, 33150, 72, CAST(N'2016-05-15 00:00:00.000' AS DateTime), CAST(N'2016-05-16 00:00:00.000' AS DateTime), CAST(N'2017-12-06 00:00:00.000' AS DateTime), CAST(N'2018-02-04 00:00:00.000' AS DateTime), N'Pedro Pedreiro Ltda', 230400000, 268430, 12, 630778)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13745, N'Reforma da Sala de Imprensa', N'Normal', N'Senado', N'Federal', N'Brasilia', N'DF', 290550.1, 305077.605, 129983.398237, 36318.7625, 48812.4168, 90, CAST(N'2016-05-26 00:00:00.000' AS DateTime), CAST(N'2016-06-02 00:00:00.000' AS DateTime), CAST(N'2016-07-25 00:00:00.000' AS DateTime), CAST(N'2016-10-11 00:00:00.000' AS DateTime), N'Grupo Celta', 581100.2, 493935.16999999993, 6, 377715.13)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (13880, N'Posto de Sa�de', N'Normal', N'Secretaria de Saude', N'Estadual', N'Americana', N'SP', 250000, 250000, 97500, 31250, 36700, 53, CAST(N'2016-06-13 00:00:00.000' AS DateTime), CAST(N'2016-06-28 00:00:00.000' AS DateTime), CAST(N'2017-01-09 00:00:00.000' AS DateTime), CAST(N'2017-01-22 00:00:00.000' AS DateTime), N'ABC Construcoes', 2866349.9, 2436397.415, 5, 9750130)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14015, N'Usina Eletrot�rmica', N'Normal', N'Secretaria de Minas e Energia', N'Estadual', N'Itu', N'SP', 2300780, 2303080.78, 943319.8, 287597.5, 268731.104, 70, CAST(N'2016-06-20 00:00:00.000' AS DateTime), CAST(N'2016-09-18 00:00:00.000' AS DateTime), CAST(N'2017-10-13 00:00:00.000' AS DateTime), CAST(N'2018-05-08 00:00:00.000' AS DateTime), N'Construtora Omicron', 50617160, 43024586, 13, 2392811.2)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14150, N'Deposito Geral', N'Normal', N'Secretaria da Fazenda', N'Estadual', N'Campinas', N'SP', 1360060.1, 1360060.1, 530423.439, 170007.5125, 133285.8898, 98, CAST(N'2016-07-11 00:00:00.000' AS DateTime), CAST(N'2016-07-11 00:00:00.000' AS DateTime), CAST(N'2017-04-07 00:00:00.000' AS DateTime), CAST(N'2017-05-22 00:00:00.000' AS DateTime), N'ABC Construcoes', 2866349.9, 2436397.415, 5, 3439619.88)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14285, N'Estacionamento', N'Normal', N'Secretaria da Fazenda', N'Estadual', N'Pelotas', N'RS', 160123.45, 161244.31415, 50759.13365, 30423.455500000004, 10888.3946, 28, CAST(N'2016-07-11 00:00:00.000' AS DateTime), CAST(N'2016-10-09 00:00:00.000' AS DateTime), CAST(N'2018-02-01 00:00:00.000' AS DateTime), CAST(N'2018-04-02 00:00:00.000' AS DateTime), N'Joao do Barro Ltda', 504111.105, 428494.43925, 6, 588129.62249999982)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14420, N'Estacionamento', N'Normal', N'Secretaria da Fazenda', N'Estadual', N'Porto Alegre', N'RS', 560123.45, 564044.31414999987, 168037.03499999997, 84018.517499999987, 38088.3946, 18, CAST(N'2016-07-14 00:00:00.000' AS DateTime), CAST(N'2016-10-12 00:00:00.000' AS DateTime), CAST(N'2017-01-10 00:00:00.000' AS DateTime), CAST(N'2017-03-11 00:00:00.000' AS DateTime), N'Joao do Barro Ltda', 504111.105, 428494.43925, 4, 588129.62249999982)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14555, N'Estacionamento', N'Normal', N'Secretaria de Transporte', N'Municipal', N'Joinville', N'SC', 70012.9, 77014.19, 27305.031, 8751.6125, 4760.8772, 10, CAST(N'2016-07-18 00:00:00.000' AS DateTime), CAST(N'2016-11-15 00:00:00.000' AS DateTime), CAST(N'2016-10-16 00:00:00.000' AS DateTime), CAST(N'2016-12-05 00:00:00.000' AS DateTime), N'ContruForte e Associados', 4450617.06, 3783024.501, 4, 70713.029)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14690, N'Deposito Graos', N'Normal', N'Secretaria de Agricultura', N'Estadual', N'Campinas', N'SP', 2450600.2, 3381828.276, 906722.074, 306325.025, 244275.827936, 70, CAST(N'2016-08-17 00:00:00.000' AS DateTime), CAST(N'2016-08-17 00:00:00.000' AS DateTime), CAST(N'2017-08-12 00:00:00.000' AS DateTime), CAST(N'2017-11-08 00:00:00.000' AS DateTime), N'Dzeta Ltda', 14703601.2, 12498061.02, 2, 2693209.6197999995)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14825, N'Deposito Graos', N'Normal', N'Secretaria de Agricultura', N'Estadual', N'Campinas', N'SP', 1890000.1, 2608200.138, 561330.0297, 236250.0125, 188395.209968, 76, CAST(N'2016-09-10 00:00:00.000' AS DateTime), CAST(N'2016-09-10 00:00:00.000' AS DateTime), CAST(N'2017-01-08 00:00:00.000' AS DateTime), CAST(N'2017-04-06 00:00:00.000' AS DateTime), N'Dzeta Ltda', 14703601.2, 12498061.02, 3, 2693209.6197999995)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (14960, N'Ex�rcito', N'Normal', N'Ministerio da Defesa', N'Federal', N'Guarulhos', N'SP', 1200450.87, 1236464.3961000005, 444166.8219, 150056.35875, 81630.65916000001, 90, CAST(N'2016-09-22 00:00:00.000' AS DateTime), CAST(N'2016-09-22 00:00:00.000' AS DateTime), CAST(N'2016-12-21 00:00:00.000' AS DateTime), CAST(N'2017-10-18 00:00:00.000' AS DateTime), N'Sigma e PI Ltda', 2400901.74, 2040766.479, 5, 1380518.5005)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15095, N'Centro de Oncologia', N'Normal', N'Secretaria de Saude', N'Estadual', N'Americana', N'SP', 7500100, 7500100, 2377531.7, 937512.5, 726009.68, 49, CAST(N'2016-09-23 00:00:00.000' AS DateTime), CAST(N'2016-10-08 00:00:00.000' AS DateTime), CAST(N'2016-10-23 00:00:00.000' AS DateTime), CAST(N'2016-11-05 00:00:00.000' AS DateTime), N'ABC Construcoes', 2866349.9, 2436397.415, 4, 9750130)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15230, N'Delegacia', N'Normal', N'Policia Civil', N'Estadual', N'Uruguaiana', N'RS', 863500.1, 863500.1, 267685.031, 218033.77525, 58718.0068, 20, CAST(N'2016-10-20 00:00:00.000' AS DateTime), CAST(N'2016-10-21 00:00:00.000' AS DateTime), CAST(N'2017-05-18 00:00:00.000' AS DateTime), CAST(N'2017-05-23 00:00:00.000' AS DateTime), N'Jose Construcoes', 863500.1, 733975.085, 7, 915310.106)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15365, N'Sala de Reuni�es', N'Normal', N'Executivo', N'Municipal', N'Olinda', N'PE', 75431.7, 104095.746, 24892.461, 9428.9625, 5129.3556, 18, CAST(N'2016-10-24 00:00:00.000' AS DateTime), CAST(N'2016-10-25 00:00:00.000' AS DateTime), CAST(N'2018-02-16 00:00:00.000' AS DateTime), CAST(N'2018-02-26 00:00:00.000' AS DateTime), N'Iota Group International', 66802.189999999988, 56781.861499999985, 12, 82220.553)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15500, N'Sala de Reuni�es', N'Normal', N'Executivo', N'Municipal', N'Recife', N'PE', 95431.7, 131695.746, 29297.5319, 11928.9625, 6489.3556, 20, CAST(N'2016-10-30 00:00:00.000' AS DateTime), CAST(N'2016-10-31 00:00:00.000' AS DateTime), CAST(N'2017-08-26 00:00:00.000' AS DateTime), CAST(N'2017-09-05 00:00:00.000' AS DateTime), N'Iota Group International', 66802.189999999988, 56781.861499999985, 2, 104020.553)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15635, N'Usina Eletrot�rmica', N'Normal', N'Secretaria de Minas e Energia', N'Estadual', N'Piracicaba', N'SP', 4300780, 4305080.7799999993, 1376249.6, 537597.5, 502331.104, 62, CAST(N'2016-11-02 00:00:00.000' AS DateTime), CAST(N'2017-01-31 00:00:00.000' AS DateTime), CAST(N'2017-06-30 00:00:00.000' AS DateTime), CAST(N'2018-01-23 00:00:00.000' AS DateTime), N'Construtora Omicron', 50617160, 43024586, 4, 2392811.2)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15770, N'Estacionamento Oktoberfest', N'Normal', N'Secretaria de Transporte', N'Municipal', N'Blumenau', N'SC', 250010.1, 275011.11000000004, 92503.737, 31251.2625, 17000.686800000003, 12, CAST(N'2016-11-19 00:00:00.000' AS DateTime), CAST(N'2016-05-09 00:00:00.000' AS DateTime), CAST(N'2017-03-19 00:00:00.000' AS DateTime), CAST(N'2017-05-08 00:00:00.000' AS DateTime), N'ContruForte e Associados', 4450617.06, 3783024.501, 9, 252510.201)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (15905, N'Central de Ar-condicionado', N'Normal', N'Executivo', N'Municipal', N'Recife', N'PE', 941300.65, 1026017.7085, 298392.30605, 117662.58125, 92247.4637, 16, CAST(N'2016-11-23 00:00:00.000' AS DateTime), CAST(N'2017-03-23 00:00:00.000' AS DateTime), CAST(N'2017-08-20 00:00:00.000' AS DateTime), CAST(N'2018-03-08 00:00:00.000' AS DateTime), N'Lambda Corporation', 16943411.7, 14401899.944999998, 10, 997778.68900000013)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16040, N'Escola T�cnica Bento Manoel', N'Normal', N'Secretaria de Educacao', N'Estadual', N'Porto Alegre', N'RS', 10010000, 11511500, 3703700, 2502500, 680680, 34, CAST(N'2016-12-02 00:00:00.000' AS DateTime), CAST(N'2016-12-09 00:00:00.000' AS DateTime), CAST(N'2017-03-02 00:00:00.000' AS DateTime), CAST(N'2017-10-01 00:00:00.000' AS DateTime), N'Empreiteira BACANA', 230400000, 195840000, 4, 16896000)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16175, N'Aeron�utica', N'Normal', N'Ministerio da Defesa', N'Federal', N'Guarulhos', N'SP', 4500940, 6211297.1999999993, 2011920.18, 562617.5, 306063.92000000004, 8, CAST(N'2016-12-12 00:00:00.000' AS DateTime), CAST(N'2016-12-19 00:00:00.000' AS DateTime), CAST(N'2017-08-09 00:00:00.000' AS DateTime), CAST(N'2017-09-22 00:00:00.000' AS DateTime), N'Upsilon Ltda', 4500940, 3825799, 5, 5041052.8000000007)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16310, N'Hospital Geral', N'Normal', N'Secretaria de Saude', N'Municipal', N'Mogi das Cruzes', N'SP', 786000, 786000, 235800, 98250, 132048, 22, CAST(N'2016-12-19 00:00:00.000' AS DateTime), CAST(N'2017-01-07 00:00:00.000' AS DateTime), CAST(N'2017-04-18 00:00:00.000' AS DateTime), CAST(N'2017-06-02 00:00:00.000' AS DateTime), N'Silva Construcoes', 98000, 83300, 7, 117600)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16445, N'Presidio Central', N'Normal', N'Ministerio da Justi�a', N'Federal', N'Passo Fundo', N'RS', 2350789.65, 2773931.7869999995, 963823.7565, 411388.18875, 213451.70022, 301, CAST(N'2017-01-29 00:00:00.000' AS DateTime), CAST(N'2017-01-29 00:00:00.000' AS DateTime), CAST(N'2017-05-29 00:00:00.000' AS DateTime), CAST(N'2017-09-26 00:00:00.000' AS DateTime), N'Grupo SHOWDEBOLA', 72874479.149999991, 61943307.277499989, 9, 2585868.615)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16580, N'Presidio de Seguran�a Maxima', N'Normal', N'Ministerio da Justi�a', N'Federal', N'Rio Grande', N'RS', 3450558.88, 3692098.0016, 1207695.6079999998, 603847.80399999989, 234638.00384, 199, CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(N'2017-02-20 00:00:00.000' AS DateTime), CAST(N'2018-07-15 00:00:00.000' AS DateTime), CAST(N'2018-11-13 00:00:00.000' AS DateTime), N'GAMA S.A.', 72874479.149999991, 61943307.277499989, 2, 4244725.4555)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16715, N'Sala de Maquinas', N'Normal', N'Executivo', N'Municipal', N'Recife', N'PE', 101550.1, 110689.609, 37268.8867, 12693.7625, 7799.04768, 14, CAST(N'2017-03-19 00:00:00.000' AS DateTime), CAST(N'2017-07-17 00:00:00.000' AS DateTime), CAST(N'2017-11-14 00:00:00.000' AS DateTime), CAST(N'2018-06-02 00:00:00.000' AS DateTime), N'Lambda Corporation', 16943411.7, 14401899.944999998, 3, 107643.106)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16850, N'Presidio Central', N'Normal', N'Ministerio da Justi�a', N'Federal', N'Porto Alegre', N'RS', 2350789.65, 2515344.9255, 916807.9635, 528927.67125, 159853.6962, 350, CAST(N'2017-03-25 00:00:00.000' AS DateTime), CAST(N'2017-03-25 00:00:00.000' AS DateTime), CAST(N'2018-09-16 00:00:00.000' AS DateTime), CAST(N'2019-01-14 00:00:00.000' AS DateTime), N'GAMA S.A.', 72874479.149999991, 61943307.277499989, 8, 2656392.3044999996)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (16985, N'Presidio Central', N'Normal', N'Ministerio da Justi�a', N'Federal', N'Rio Grande', N'RS', 2350789.65, 2773931.7869999995, 893300.067, 528927.67125, 159853.6962, 350, CAST(N'2017-03-25 00:00:00.000' AS DateTime), CAST(N'2017-03-25 00:00:00.000' AS DateTime), CAST(N'2018-09-16 00:00:00.000' AS DateTime), CAST(N'2019-01-14 00:00:00.000' AS DateTime), N'Grupo SHOWDEBOLA', 72874479.149999991, 61943307.277499989, 8, 2585868.615)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (17120, N'Escola T�cnica Bento Gon�alves', N'Normal', N'Secretaria de Educacao', N'Estadual', N'Caxias do Sul', N'RS', 1360000, 1360000, 408000, 133280, 119680, 44, CAST(N'2017-05-02 00:00:00.000' AS DateTime), CAST(N'2017-05-09 00:00:00.000' AS DateTime), CAST(N'2017-11-28 00:00:00.000' AS DateTime), CAST(N'2018-06-29 00:00:00.000' AS DateTime), N'Pedro Pedreiro Ltda', 230400000, 195840000, 14, 16588800.000000002)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (17255, N'Escola T�cnica Bento Gon�alves', N'Suspensa', N'Secretaria de Educacao', N'Estadual', N'Caxias do Sul', N'RS', 1536000, 1536000, 476160, 399052.8, 73728, 40, CAST(N'2017-05-15 00:00:00.000' AS DateTime), CAST(N'2017-05-22 00:00:00.000' AS DateTime), CAST(N'2017-10-12 00:00:00.000' AS DateTime), CAST(N'2018-05-13 00:00:00.000' AS DateTime), N'Empreiteira BACANA', 230400000, 195840000, 3, 16896000)
GO
INSERT [dbo].[Licitacao] ([Identificador], [Projeto], [Situacao], [Solicitante], [Esfera], [Municipio], [Estado], [Valor_Previsto], [Valor_Realizado], [Imposto_Federal], [Imposto_Estadual], [Imposto_Municipal], [Profissionais], [Data_Inicio_Prev], [Data_Inicio_Real], [Data_Fim_Prev], [Data_Fim_Real], [Empresa_Licitante], [Faturamento_1Ano_Anterior], [Faturamento_2Ano_Anterior], [Numero_Concorrentes], [Lance_2Colocado]) VALUES (17390, N'Escola T�cnica Monteiro Lobato', N'Normal', N'Secretaria de Educacao', N'Estadual', N'Taquara', N'RS', 1361000, 1565149.9999999998, 299420, 340250, 92548, 45, CAST(N'2017-05-15 00:00:00.000' AS DateTime), CAST(N'2017-05-22 00:00:00.000' AS DateTime), CAST(N'2017-09-12 00:00:00.000' AS DateTime), CAST(N'2018-04-13 00:00:00.000' AS DateTime), N'Pedro Pedreiro Ltda', 230400000, 195840000, 3, 16588800.000000002)
GO

SELECT * FROM LICITACAO

TRUNCATE TABLE LICITACAO

--Obtem lista de liguagens disponiveis
 
select * from syslanguages
where dateformat = 'ymd'
 
--Verifica limguagem padr�o
 
select name ,alias, dateformat from syslanguages
 
where langid=(select value from master..sysconfigures
 
where comment ='default language');

--Configura linguagem padrao do servidor
 
exec sp_configure'default language', 27--Brazilian
 
reconfigure with override
 
--Configura linguagem padrao(Portugues) para o usuario SA
 
ALTER LOGIN sa WITH DEFAULT_LANGUAGE= Brazilian --para ingles USA use: English

SET DATEFORMAT ymd


 