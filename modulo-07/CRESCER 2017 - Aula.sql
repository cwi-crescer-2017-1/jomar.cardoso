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

SELECT * FROM USER_TABLES;
SELECT * FROM USER_VIEWS;
SELECT USER FROM DUAL;
EXEC dbms_stats.gather_schema_stats( USER );

/*  
Exercício 1: Produtos inativos
Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses. 
336 RESULTADOS
*/


  CREATE VIEW vwPRODUTOS_SEM_COMPRA AS
  SELECT *
  FROM PRODUTO 
  WHERE IDPRODUTO NOT IN (SELECT IDPRODUTO FROM VWPRODUTOSRECENTES);
  
  CREATE OR REPLACE VIEW vwPRODUTOSRECENTES AS
  SELECT PEI.IDPRODUTO 
  FROM PEDIDOITEM PEI
  INNER JOIN PEDIDO PED ON PED.IDPEDIDO = PEI.IDPEDIDO
  WHERE PED.DATAPEDIDO > ADD_MONTHS(TRUNC(SYSDATE), -4)

/*
Exercício 2: Alterando status
Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.
*/

UPDATE PRODUTO
SET SITUACAO = 'I'
WHERE EXISTS (SELECT IDPRODUTO 
                    FROM VWPRODUTOS_SEM_COMPRA VW
                    WHERE PRODUTO.IDPRODUTO = VW.IDPRODUTO);
                    
SELECT SUM(ITEM.QUANTIDADE) QTDE
FOR PEDIDOITEM ITEM
  INNER JOIN PEDIDO PED ON PED.IDPEDIDO = ITEM.IDPEDIDO
  WHERE ITEM.IDPRODUTO = 
  AND PED.DATAPEDIDO >= TRUNC(SYSDATE, 'YYYY');
  