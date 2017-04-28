--Cópia de uma tabela
--Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. Considere todos os registros existentes.

SELECT * INTO CidadeAux FROM Cidade;

--Copiando dados parciais
--Limpe a tabela CidadeAux (Truncate table CidadeAux). 
E em seguida insira todas os registros da tabela Cidade onde o estado seja RS.

Truncate table CidadeAux;
INSERT INTO CidadeAux SELECT * FROM Cidade WHERE UF = 'RS';
SELECT * FROM CidadeAux;

--Criando uma tabela
--Crie uma tabela para armazenar informações de produtos. Devem ter os seguintes atributos:
--Código de identificação;
--Nome curto,
--Nome descritivo,
--Data da criação,
--Local no estoque,
--Quantidade e
--Preço.

CREATE TABLE PRODUTOS
	(COD INT NOT NULL PRIMARY KEY,
	 NOME VARCHAR(30) NOT NULL,
	 DESCRICAO VARCHAR(60),
	 DATACRIACAO DATE,
	 LOCALNOESTOQUE VARCHAR(15),
	 QUANTIDADE INT,
	 PRECO FLOAT
	 );

-- Inserindo registros
-- Crie dois registros nessa tabela nova (produto).
BEGIN TRANSACTION
INSERT INTO PRODUTOS (COD, NOME, DESCRICAO, DATACRIACAO, LOCALNOESTOQUE, QUANTIDADE, PRECO)
VALUES(1, 'BOLACHA', 'SALGADA COM SAL', '15-02-2016', 'PBE1515', 450, 2.40);
INSERT INTO PRODUTOS (COD, NOME, DESCRICAO, DATACRIACAO, LOCALNOESTOQUE, QUANTIDADE, PRECO)
VALUES(2, 'BOLACHA', 'DOCE COM AÇUCAR', '10-03-2016', 'PBE2515', 120, 2.56);
COMMIT 
ROLLBACK
SELECT * FROM PRODUTOS;