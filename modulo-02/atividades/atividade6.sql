SELECT * FROM Cliente
SELECT * FROM Cidade
SELECT * FROM Material
SELECT * FROM Pedido
SELECT * FROM PedidoItem
SELECT * FROM Produto
SELECT * FROM ProdutoMaterial

/*
			## Exerc�cio 1: Primeiro nome
Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
Exemplo de resultado esperado:
PrimeiroNome	TotalOcorrencias
Juvenita		7
*/

CREATE VIEW vwPRIMEIRO_NOME AS
SELECT SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) -1) AS PrimeiroNome
FROM Cliente C;

SELECT TOP 1	P.PrimeiroNome AS PrimeiroNome,
				COUNT(1) AS TotalOcorrencias
FROM	vwPRIMEIRO_NOME P
GROUP BY P.PrimeiroNome
ORDER BY COUNT(1) DESC

/*
			## Exerc�cio 2: Total do M�s
Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.
	Exemplo de resultado esperado:
	Quantidade		ValorPedido
	469				22,817,022.06
*/

SELECT COUNT(1), SUM(ValorPedido)
FROM Pedido
WHERE	DATEPART(MONTH, DataPedido) = 4
AND		DATEPART(YEAR, DataPedido) = 2017


/*
			## Exerc�cio 3: Estados x Clientes
Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero
de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes.
	Exemplo de resultado esperado:
	UF		TotalClientes
	AC		24
	MG		2008
*/

CREATE VIEW vwClientes_Por_Estados AS
SELECT UF, COUNT(1) AS TotalClientes
FROM Cidade Ci
INNER JOIN Cliente Cl ON Ci.IDCidade = Cl.IDCidade
GROUP BY Ci.UF;

CREATE VIEW vwEstado_Mais_Clientes AS
SELECT TOP 1 COUNT(1) AS Mais
FROM Cidade Cid
INNER JOIN Cliente Cli ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY Mais DESC;

CREATE VIEW vwEstado_Menos_Clientes AS
SELECT TOP 1 COUNT(1) AS Menos
FROM Cidade Cid
INNER JOIN Cliente Cli ON Cid.IDCidade = Cli.IDCidade
GROUP BY Cid.UF
ORDER BY Menos;

SELECT S.UF, S.TotalClientes
FROM vwClientes_Por_Estados S
WHERE S.TotalClientes = (SELECT TOP 1 COUNT(1) AS Mais --nao consegui adicionar view
						 FROM Cidade Cid
						 INNER JOIN Cliente Cli ON Cid.IDCidade = Cli.IDCidade
						 GROUP BY Cid.UF
						 ORDER BY Mais DESC)
OR S.TotalClientes =	(SELECT TOP 1 COUNT(1) AS Menos --nao consegui adicionar view
						 FROM Cidade Cid
						 INNER JOIN Cliente Cli ON Cid.IDCidade = Cli.IDCidade
						 GROUP BY Cid.UF
						 ORDER BY Menos)

/*
			## Exerc�cio 4: Novo Produto
Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
	* Nome: Galocha Maragato
	* Pre�o de custo: 35.67
	* Pre�o de venda: 77.95
	* Situa��o: A
*/

BEGIN TRANSACTION
INSERT INTO Produto (Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A');
ROLLBACK
COMMIT

/*
			## Exerc�cio 5: Produtos n�o comprados
Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos
no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido 
(ser� preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente dever� ser listado (apenas este)
*/

CREATE VIEW vwIDProduto_PedidoItem AS
SELECT IDProduto
FROM PedidoItem;

SELECT Pr.Nome
FROM Produto Pr
LEFT JOIN PedidoItem PeI	ON Pei.IDProduto = Pr.IDProduto
WHERE Pr.IDProduto NOT IN (SELECT IDProduto
							FROM PedidoItem)

/*
			## Exerc�cio 6: Principais Produtos
Liste os 30 produtos que mais geraram lucro em 2016.
*/

SELECT * FROM Pedido
SELECT * FROM PedidoItem
SELECT * FROM Produto

CREATE VIEW vwPedidos_2016 AS
SELECT * FROM Pedido P WHERE DATEPART(YEAR, P.DataPedido) = 2016;

CREATE VIEW vwSumValorPedidos AS
SELECT Pei.IDProduto, SUM(Pe.ValorPedido) AS Total FROM PedidoItem PeI 
LEFT JOIN vwPedidos_2016 Pe	ON Pe.IDPedido = PeI.IDPedido GROUP BY PeI.IDProduto


SELECT TOP 30 *
FROM Produto Pr
LEFT JOIN vwSumValorPedidos PeI	ON Pei.IDProduto = Pr.IDProduto
ORDER BY Pei.Total DESC
