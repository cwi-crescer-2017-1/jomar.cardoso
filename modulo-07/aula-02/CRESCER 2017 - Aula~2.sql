/*
Exerc�cio 1: Cidades Duplicadas
Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
Fa�a um c�digo (PL/SQL) que liste quais s�o as cidades duplicadas. 
Ap�s isso liste todos os clientes que est�o relacionados com estas cidades
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

/*------------------------sidades repetidas------------------------*/
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

/* 
Exerc�cio 2: Atualizando Valor do Pedido
Fa�a uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e ent�o verificar o valor total
de seus itens (quantidade x valor unit�rio).
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

/*
Exerc�cio 3: Atualiza��o de Clientes
Crie uma rotina que atualize todos os clientes que n�o realizaram nenhum pedido nos �ltimos 6 meses 
(considere apenas o m�s, dia 01 do 6� m�s anterior). Definir o atributo Situacao para I.
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

























