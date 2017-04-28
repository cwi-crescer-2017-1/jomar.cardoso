--Fa�a uma consulta que retorne os empregados em ordem de admiss�o, projetar apenas ID e Nome.

SELECT IDEMPREGADO, NOMEEMPREGADO 
	FROM EMPREGADO
	ORDER BY DATAADMISSAO


--Fa�a uma consulta que liste todos os empregados que n�o recebam comiss�o, deve ser ordenado pelo sal�rio.

SELECT *
	FROM EMPREGADO
	WHERE COMISSAO IS NULL 
	ORDER BY SALARIO 

/*
Fa�a uma consulta que retorno o nome dos empregados, o sal�rio anual (considere 13 sal�rios), 
projete tamb�m a comiss�o (considere 12x). As colunas que dever�o ser exibidas s�o:
ID do Empregado
Nome
Salario Anual
Comiss�o Anual
Renda Anual */

SELECT IDEMPREGADO, NOMEEMPREGADO, NOMEEMPREGADO, SALARIO*13 AS SALARIO_ANUAL,
	COMISSAO*12 AS COMISSAO_ANUAL, (SALARIO*13 + COMISSAO*12) AS RENDA_ANUAL
	FROM EMPREGADO

/*
Fa�a uma consulta que liste todos os empregados que tenham o sal�rio anual seja inferior a R$ 18500 
ou que tenham o cargo de Atendente. Projetar as seguintes colunas:
ID do Empregado
Nome
Cargo
Sal�rio Mensal*/



SELECT IDEMPREGADO, NOMEEMPREGADO, CARGO, SALARIO
	FROM EMPREGADO
	WHERE SALARIO*13 < 18500
	   OR CARGO = 'ATENDENTE'