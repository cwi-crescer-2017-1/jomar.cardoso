SELECT * FROM Empregado
SELECT * FROM Departamento

--Exercício 1: Múltiplos acessos
--Liste o nome do empregado, o nome do gerente e o departamento de cada um.

SELECT E.NomeEmpregado AS Nome_Empregado, G.NomeEmpregado AS Nome_Gerente, D.NomeDepartamento
FROM Empregado E
LEFT JOIN Empregado G ON E.IDGerente = G.IDEmpregado
LEFT JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento

/*
Exercício 2: Maior Salário
Liste o deparamento (id e nome) com o empregado de maior salário.
*/

SELECT DISTINCT D.IDDepartamento, D.NomeDepartamento
FROM Empregado E
INNER JOIN Departamento D ON E.IDDepartamento = D.IDDepartamento
WHERE E.Salario =	(SELECT MAX(C.Salario)
					 FROM Empregado C
					 WHERE C.IDDepartamento IS NOT NULL)

/*
Exercício 3: Reajuste salarial
Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO,
 este reajuste deve ser de 17,3%. Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
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
Exercício 4: Cidades duplicadas
Liste todas as cidades duplicadas (nome e UF iguais).
*/

SELECT Nome,UF 
FROM Cidade
GROUP BY Nome, UF
HAVING COUNT(1) > 1

/*
Exercício 5: Definindo Cidades
Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas atenção! apenas a cidade com maior ID deve ser alterada.
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
Explicação adicional - VIEW

Para reaproveitar uma consulta SQL um dos recursos oferecidos é a criação de VIEWS. Neste recurso o comando SQL é salvo no dicionário de dados do SGBD e pode ser reutilizado novamente.

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