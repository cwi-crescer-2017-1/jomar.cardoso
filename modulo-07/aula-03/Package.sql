/*
Exerc�cio 1: Cidades Duplicadas
A partir do conhecimento de procedures/functions e packages obtidos (rapidamente)
crie uma package que permita eliminar cidades duplicadas. Para essa tarefa respeite
as seguintes regras: -> identifique as cidades duplicadas; -> identifique os clientes 
que est�o relacionados com ela; -> altere no cliente (idcidade) para manter apenas 
a cidade duplicada de menor ID; -> certificando-se que n�o h� mais clientes 
utilizando cidades duplicadas elimine-as.
Utilize uma codifica��o que possibilite o uso de teste unit�rio.
*/

CREATE OR REPLACE PACKAGE ELIMINAR_CIDADES_REPETIDAS AS
    PROCEDURE VERIFICA_CIDADES_REPETIDAS;
    PROCEDURE EXECUTAR;
    PROCEDURE VERIFICA_CLIENTES_NAS_CIDADES (C_NOME IN VARCHAR2, C_UF IN VARCHAR2, C_NOVO_ID_CIDADE IN NUMBER);
    PROCEDURE ATUALIZAR_CLIENTE_CIDADE(C_IDCLIENTE IN NUMBER, C_NOVO_ID_CIDADE IN NUMBER);
END;

CREATE OR REPLACE PACKAGE BODY ELIMINAR_CIDADES_REPETIDAS AS
    /*------*/
    PROCEDURE VERIFICA_CIDADES_REPETIDAS IS
    BEGIN
        DECLARE 
            CURSOR CIDADES_REPETIDAS IS
                SELECT NOME, UF, MIN(IDCIDADE) AS MIN_IDCIDADE
                FROM CIDADE
                GROUP BY NOME, UF
                HAVING COUNT(1) >1;
            BEGIN
                FOR CIDADE IN CIDADES_REPETIDAS LOOP
                    DBMS_OUTPUT.PUT_LINE('Cidade: ' || CIDADE.NOME || ' - ' || CIDADE.UF);
                    VERIFICA_CLIENTES_NAS_CIDADES(CIDADE.NOME, CIDADE.UF, CIDADE.MIN_IDCIDADE);
                END LOOP;
            END;
    END VERIFICA_CIDADES_REPETIDAS;
    /*------*/
    PROCEDURE VERIFICA_CLIENTES_NAS_CIDADES (C_NOME IN VARCHAR2, C_UF IN VARCHAR2, C_NOVO_ID_CIDADE IN NUMBER) IS
    BEGIN
        DECLARE
            CURSOR CLIENTES_NAS_CIDADES (C_NOME IN VARCHAR2, C_UF   IN VARCHAR2) IS
                SELECT CLI.IDCLIENTE, CLI.NOME
                FROM CLIENTE CLI
                INNER JOIN CIDADE CID ON CID.IDCIDADE = CLI.IDCIDADE
                WHERE CID.NOME = C_NOME
                AND CID.UF = C_UF;
        BEGIN
            FOR CLIENTE IN CLIENTES_NAS_CIDADES(C_NOME, C_UF) LOOP
                DBMS_OUTPUT.PUT_LINE('Cliente: ' || CLIENTE.NOME);
                ATUALIZAR_CLIENTE_CIDADE(CLIENTE.IDCLIENTE, C_NOVO_ID_CIDADE);
            END LOOP;
        END;
    END VERIFICA_CLIENTES_NAS_CIDADES;
    /*------*/
    PROCEDURE ATUALIZAR_CLIENTE_CIDADE(C_IDCLIENTE IN NUMBER, C_NOVO_ID_CIDADE IN NUMBER) IS
    BEGIN
        UPDATE CLIENTE SET IDCIDADE = C_NOVO_ID_CIDADE WHERE IDCLIENTE = C_IDCLIENTE;
        DBMS_OUTPUT.PUT_LINE(C_NOVO_ID_CIDADE);
    END ATUALIZAR_CLIENTE_CIDADE;
    /*------*/
    PROCEDURE EXECUTAR IS
    BEGIN
        VERIFICA_CIDADES_REPETIDAS;
    END EXECUTAR;
END;    

EXEC ELIMINAR_CIDADES_REPETIDAS.EXECUTAR;

















