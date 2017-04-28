--Faça uma consulta que retorne os empregados em ordem de admissão, projetar apenas ID e Nome.

SELECT IDEMPREGADO, NOMEEMPREGADO 
	FROM EMPREGADO
	ORDER BY DATAADMISSAO


--Faça uma consulta que liste todos os empregados que não recebam comissão, deve ser ordenado pelo salário.

SELECT *
	FROM EMPREGADO
	WHERE COMISSAO IS NULL 
	ORDER BY SALARIO 

/*
Faça uma consulta que retorno o nome dos empregados, o salário anual (considere 13 salários), 
projete também a comissão (considere 12x). As colunas que deverão ser exibidas são:
ID do Empregado
Nome
Salario Anual
Comissão Anual
Renda Anual */

SELECT IDEMPREGADO, NOMEEMPREGADO, NOMEEMPREGADO, SALARIO*13 AS SALARIO_ANUAL,
	COMISSAO*12 AS COMISSAO_ANUAL, (SALARIO*13 + COMISSAO*12) AS RENDA_ANUAL
	FROM EMPREGADO

/*
Faça uma consulta que liste todos os empregados que tenham o salário anual seja inferior a R$ 18500 
ou que tenham o cargo de Atendente. Projetar as seguintes colunas:
ID do Empregado
Nome
Cargo
Salário Mensal*/



SELECT IDEMPREGADO, NOMEEMPREGADO, CARGO, SALARIO
	FROM EMPREGADO
	WHERE SALARIO*13 < 18500
	   OR CARGO = 'ATENDENTE'