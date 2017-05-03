SELECT * FROM Empregado
SELECT * FROM Departamento

--Exerc�cio 1: M�ltiplos acessos
--Liste o nome do empregado, o nome do gerente e o departamento de cada um.

SELECT E.NomeEmpregado AS Nome_Empregado, G.NomeEmpregado AS Nome_Gerente, D.NomeDepartamento
FROM Empregado E
LEFT JOIN Empregado G ON E.IDGerente = G.IDEmpregado
LEFT JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento

/*
Exerc�cio 2: Maior Sal�rio
Liste o deparamento (id e nome) com o empregado de maior sal�rio.
*/

SELECT DISTINCT D.IDDepartamento, D.NomeDepartamento
FROM Empregado E
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento
WHERE E.Salario =	(SELECT MAX(C.Salario)
					 FROM Empregado C
					 WHERE C.IDDepartamento IS NOT NULL)

/*
Exerc�cio 3: Reajuste salarial
Aplique uma altera��o salarial em todos os empregados que o departamento fique na localidade de SAO PAULO,
 este reajuste deve ser de 17,3%. Por seguran�a fa�a uma c�pia da tabela Empregado antes de iniciar esta tarefa.
*/

--SELECT * INTO EmpregadoAux FROM Empregado
--SELECT * FROM EmpregadoAux
BEGIN TRANSACTION
GO
UPDATE Empregado
SET salario = Salario*1.173
WHERE IDDepartamento IN	(SELECT IDDepartamento
						FROM Departamento D
						WHERE D.Localizacao = 'SAO PAULO')
COMMIT
GO

/*
Exerc�cio 4: Cidades duplicadas
Liste todas as cidades duplicadas (nome e UF iguais).
*/

SELECT Nome,UF 
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(1) > 1

/*
Exerc�cio 5: Definindo Cidades
Fa�a uma altera�ao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas aten��o! apenas a cidade com maior ID deve ser alterada.
*/

BEGIN TRANSACTION
GO
UPDATE Cidade
SET Nome = Nome + '*'
WHERE Nome+UF IN (SELECT Nome+UF
	FROM Cidade
	GROUP BY Nome, UF
	HAVING COUNT(1) > 1)
AND IDCidade IN
	(SELECT MAX(IDCidade)
	FROM Cidade
	GROUP BY Nome, UF
	HAVING COUNT(1) > 1)
COMMIT
ROLLBACK
GO

/*
Explica��o adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos � a cria��o de VIEWS. Neste recurso o comando SQL � salvo no dicion�rio de dados do SGBD e pode ser reutilizado novamente.

Um exemplo disso seria uma consulta que retorna apenas as cidades do RS.

Create view vwCidades_Gauchas as
   Select IDCidade,
          Nome
   From   Cidade
   Where  UF = 'RS';
Para utilizar esta consulta ela deve ser referenciada no FROM como se fosse uma fonte de dados qualquer:

Select IDCidade, 
       Nome 
  From vwCidades_Gauchas;