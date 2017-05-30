INSERT INTO Pedido (NomeCliente)
 VALUES( 'Jomar')

SELECT Id, NomeCliente
FROM Pedido

INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade)
 VALUES(1, 1, 25)

 SELECT * FROM ItemPedido

 SELECT IPo.Id, IPo.PedidoId, IPo.ProdutoId, IPo.Quantidade
  FROM Pedido Ped
  INNER JOIN ItemPedido IPo ON Ped.Id = IPo.PedidoId
  WHERE Ped.Id = 1
  

  SELECT Pr.IDProjeto, SUM(Li.Custo) AS 'Gasto em ligações no projeto' 
FROM Projeto Pr
	INNER JOIN Emprestimo Em ON Pr.IDProjeto = Em.IDProjeto
	INNER JOIN EmprestimoChip Ec ON Em.IDEmprestimo = Ec.IDEmprestimo
	INNER JOIN Chip Ch ON Ch.IDChip = Ec.IDChip
	INNER JOIN Ligacao Li ON Li.IDChip = Ch.IDChip
WHERE Li.Data BETWEEN Em.DataInicio AND Em.DataFinal
GROUP BY Pr.IDProjeto;