/* 
1 - Fa�a uma consulta que liste o total de empregados admitidos no ano de 1980. 
Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admiss�o.
*/
SELECT IDEMPREGADO, NOMEEMPREGADO, FLOOR(DATEDIFF(DAY, DATANASCIMENTO, GETDATE()) / 365.25) AS IDADE 
FROM EMPREGADO;

/*
2 - Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro.
 ** DICA: Pesquise recursos espec�ficos para esta funcionalidade.
*/

SELECT TOP 1 CARGO
FROM EMPREGADO

/*
3 - Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/

SELECT COUNT(NOME), UF
FROM CIDADE
GROUP BY UF

/*
4 - Crie um novo departamento, denominado 'Inova��o' com localiza��o em 'S�O LEOPOLDO'. 
Todos os empregados que foram admitidos no m�s de dezembro (qualquer ano) que n�o ocupam o cargo de 'Atendente' 
devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inova��o).
*/

INSERT INTO DEPARTAMENTO VALUES (50,'Inova��es', 'SAO LEOPOLDO');

UPDATE EMPREGADO SET IDDEPARTAMENTO = 50 WHERE ( MONTH(DATANASCIMENTO)=12 )
AND CARGO <> 'ATENDENTE'

SELECT * 
FROM EMPREGADO
WHERE ( MONTH(DATANASCIMENTO)=12 )
AND CARGO <> 'ATENDENTE'