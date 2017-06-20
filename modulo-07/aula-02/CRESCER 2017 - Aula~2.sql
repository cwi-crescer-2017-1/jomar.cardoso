/*
Exercício 1: Cidades Duplicadas
Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
Após isso liste todos os clientes que estão relacionados com estas cidades
*/

/*-----------------------todos os clientes-------------------------*/
DECLARE
  CURSOR TODOS_CLIENTES IS
    SELECT CL.NOME NOME_CLIENTE, CI.NOME NOME_CIDADE
    FROM CLIENTE CL
    INNER JOIN CIDADE CI ON CI.IDCIDADE = CL.IDCIDADE;
    
BEGIN
  FOR UM_CLIENTE IN TODOS_CLIENTES LOOP
    DBMS_OUTPUT.PUT_LINE(UM_CLIENTE.NOME_CLIENTE);
  END LOOP;  
END;

/*------------------------cidades repetidas------------------------*/
DECLARE
  CURSOR REPETIDOS IS
    SELECT NOME, UF 
      FROM CIDADE
      GROUP BY NOME, UF
      HAVING COUNT(1) > 1;
      
BEGIN
  FOR REPETIDO IN REPETIDOS LOOP
    DBMS_OUTPUT.PUT_LINE(REPETIDO.NOME);
  END LOOP;  
END;

/*-----------------------clientes nas cidades repetidas-------------------------*/
DECLARE
  CURSOR TODOS_CLIENTES IS
    SELECT CL.NOME NOME_CLIENTE, CI.NOME NOME_CIDADE
    FROM CLIENTE CL
    INNER JOIN CIDADE CI ON CI.IDCIDADE = CL.IDCIDADE;
  CURSOR REPETIDOS IS
    SELECT NOME, UF 
      FROM CIDADE
      GROUP BY NOME, UF
      HAVING COUNT(1) > 1;   

BEGIN
  FOR REPETIDO IN REPETIDOS LOOP
    FOR UM_CLIENTE IN TODOS_CLIENTES LOOP
      IF (UM_CLIENTE.NOME_CIDADE = REPETIDO.NOME) THEN
        DBMS_OUTPUT.PUT_LINE(UM_CLIENTE.NOME_CIDADE || ' - ' || UM_CLIENTE.NOME_CLIENTE);
      END IF;        
    END LOOP;
  END LOOP;    
END;

CREATE INDEX IX_CIDADE_NOMEUF ON CIDADE (NOME,UF);
CREATE INDEX IX_CLIENTE_CIDADE ON CLIENTE (IDCIDADE);


/*-------------------refatorado---------------------------*/

declare
  cursor c_cidades is
       select Nome, UF
       from   Cidade
       group  by Nome, UF
       having count(1) >1;
  cursor c_clientes (pNome in varchar2,
                     pUF   in varchar2) is
     select cli.IDCliente,
            cli.Nome as Nome_Cliente,
            cid.Nome as Nome_Cidade,
            cid.UF
     from   Cliente cli
      inner join Cidade cid on cid.IDCidade = cli.IDCidade
     where  cid.Nome = pNome
     and    cid.UF   = pUF;
begin
  FOR c in c_cidades LOOP     
      dbms_output.put_line('Cidade: '|| c.Nome );
      FOR i in c_clientes (c.Nome, c.UF) LOOP
           dbms_output.put_line('Cliente: '|| i.Nome_Cliente );
      END LOOP;
  END LOOP;
end;
-- índices para melhorar o desempenho (execute apenas 1 vez)
create index IX_Cidade_NomeUF   on Cidade (Nome,UF);
create index IX_Cliente_Cidade  on Cliente (IDCidade);

/* 
Exercício 2: Atualizando Valor do Pedido
Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e então verificar o valor total
de seus itens (quantidade x valor unitário).
*/

DECLARE
  vVALOR_PEDIDO NUMBER;
  CURSOR TODOS_PEDIDOS IS  
  SELECT IDPEDIDO
    FROM PEDIDO;    
  CURSOR VALOR_ITENS (vID_PEDIDO IN NUMBER) IS
  SELECT SUM(QUANTIDADE * PRECOUNITARIO) AS VALOR_TOTAL
    FROM PEDIDOITEM
   WHERE IDPEDIDO = vID_PEDIDO
   GROUP BY IDPEDIDO;  
BEGIN
  FOR UM_PEDIDO IN TODOS_PEDIDOS LOOP
    FOR VALOR_ITEM IN VALOR_ITENS(UM_PEDIDO.IDPEDIDO) LOOP      
      vVALOR_PEDIDO := VALOR_ITEM.VALOR_TOTAL;             
      DBMS_OUTPUT.PUT_LINE( UM_PEDIDO.IDPEDIDO || ' - ' || vVALOR_PEDIDO );
    END LOOP;
    UPDATE PEDIDO SET VALORPEDIDO = vVALOR_PEDIDO
    WHERE IDPEDIDO = UM_PEDIDO.IDPEDIDO;
  END LOOP;
END;
COMMIT;


/*-----------------refactor----------------------*/

CREATE OR REPLACE
PROCEDURE Atualiza_Valor_Pedido (pIDPedido IN INTEGER) AS
  vValorPedido  Pedido.ValorPedido%type;
BEGIN
   Select SUM(Quantidade * PrecoUnitario)
   into   vValorPedido
   From   PedidoItem
   Where  IDPedido = pIDPedido;
   
   Update Pedido
   Set    ValorPedido = vValorPedido
   Where  IDPedido    = pIDPedido;
END;

/*
Exercício 3: Atualização de Clientes
Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido nos últimos 6 meses 
(considere apenas o mês, dia 01 do 6º mês anterior). Definir o atributo Situacao para I.
*/

DECLARE
    vCLIENTE_I NUMBER;
    vCONTEM CHAR(1);
    CURSOR TODOS_PEDIDOS IS
        SELECT IDCLIENTE
        FROM PEDIDO PED
        WHERE PED.DATAPEDIDO > ADD_MONTHS(TRUNC(SYSDATE), -6);
    CURSOR TODOS_CLIENTES IS
        SELECT IDCLIENTE, NOME, SITUACAO 
        FROM CLIENTE;
BEGIN    
    FOR UM_CLIENTE IN TODOS_CLIENTES LOOP
        vCONTEM := 'N';
        vCLIENTE_I := UM_CLIENTE.IDCLIENTE;
        FOR UM_PEDIDO IN TODOS_PEDIDOS LOOP
            IF (UM_CLIENTE.IDCLIENTE = UM_PEDIDO.IDCLIENTE) THEN
                vCONTEM := 'Y';                
            END IF;
            EXIT WHEN vCONTEM = 'Y';
        END LOOP;
        IF ( vCONTEM = 'N') THEN
            UPDATE CLIENTE SET SITUACAO = 'I';
            DBMS_OUTPUT.PUT_LINE(UM_CLIENTE.NOME || ' - ' || UM_CLIENTE.SITUACAO);
        END IF;
    END LOOP;
END;


/*
Exercício 4: Previsão de Materiais
Faça uma rotina que receba dois parâmetros:
IDProduto
Mês e Ano
E então faça uma rotina que verifique no ANO/MÊS para o produto informado qual a lista de materiais
(incluindo a quantidade) é necessário para atender todos os Pedidos desde período.
Deve imprimir o nome do material e quantidade total.
*/

DECLARE 
    CURSOR PEDIDOS_DO_MES (vANO IN NUMBER, vMES IN NUMBER) IS
    SELECT IDPEDIDO
    FROM PEDIDO
    WHERE EXTRACT(YEAR FROM DATAPEDIDO) = vANO
    AND EXTRACT(MONTH FROM DATAPEDIDO) = vMES;
    
    CURSOR PEDIDOS_ITENS (vID_PEDIDO IN NUMBER) IS
    SELECT IDPRODUTO
    FROM PEDIDOITEM
    WHERE IDPEDIDO = vID_PEDIDO;
    
    CURSOR TODOS_PRODUTOS (vID_PRODUTO IN NUMBER) IS
    SELECT IDMATERIAL, QUANTIDADE
    FROM PRODUTOMATERIAL
    WHERE IDPRODUTO = vID_PRODUTO;
    
    CURSOR TODOS_MATERIAIS (vID_MATERIAL IN NUMBER) IS
    SELECT DESCRICAO
    FROM MATERIAL
    WHERE IDMATERIAL = vID_MATERIAL;

BEGIN
    FOR UM_PEDIDO IN PEDIDOS_DO_MES(2014, 6) LOOP
        FOR UM_PEDIDO_ITEM IN PEDIDOS_ITENS(UM_PEDIDO.IDPEDIDO) LOOP
            FOR UM_PRODUTO IN TODOS_PRODUTOS(UM_PEDIDO_ITEM.IDPRODUTO) LOOP
                FOR UM_MATERIAL IN TODOS_MATERIAIS(UM_PRODUTO.IDMATERIAL) LOOP
                    DBMS_OUTPUT.PUT_LINE(UM_MATERIAL.DESCRICAO || ' - ' || UM_PRODUTO.QUANTIDADE);
                END LOOP;
            END LOOP;
        END LOOP;
    END LOOP;
END;





















