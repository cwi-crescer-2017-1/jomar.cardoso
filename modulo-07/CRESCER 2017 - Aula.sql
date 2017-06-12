CREATE TABLE Pessoa (
  IDPessoa  integer not null,
  Nome      varchar2(30) not null,
    constraint PK_Pessoa primary key (IdPessoa)
);

CREATE SEQUENCE SqPessoa;

INSERT INTO Pessoa (IdPessoa, Nome)
  VALUES  (SQPessoa.nextval, 'Andre');
  
  COMMIT;


SELECT * FROM PEDIDO

/*  
Exercício 1: Produtos inativos
Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses. 
336 RESULTADOS
*/

SELECT  PRO.NOME
  FROM PRODUTO PRO 
  RIGHT OUTER JOIN PEDIDOITEM PEI ON PEI.IDPRODUTO = PRO.IDPRODUTO
  INNER JOIN PEDIDO PED ON PED.IDPEDIDO = PEI.IDPEDIDO
  WHERE PED.DATAPEDIDO > ADD_MONTHS((SELECT SYSDATE FROM DUAL), 4)
  GROUP BY PRO.IDPRODUTO;
  
  
  SELECT * FROM
  FROM PEDIDO
  WHERE PEDIDO.DATAPEDIDO > ADD_MONTHS((SELECT SYSDATE FROM DUAL), 4)
/*
Exercício 2: Alterando status
Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.
*/


  