/* 
1 - Faça uma consulta que liste o total de empregados admitidos no ano de 1980. 
Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
*/
SELECT IDEMPREGADO, NOMEEMPREGADO, FLOOR(DATEDIFF(DAY, DATANASCIMENTO, GETDATE()) / 365.25) AS IDADE 
FROM EMPREGADO;

/*
2 - Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro.
 ** DICA: Pesquise recursos específicos para esta funcionalidade.
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
4 - Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. 
Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente' 
devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inovação).
*/

INSERT INTO DEPARTAMENTO VALUES (50,'Inovações', 'SAO LEOPOLDO');

UPDATE EMPREGADO SET IDDEPARTAMENTO = 50 WHERE ( MONTH(DATANASCIMENTO)=12 )
AND CARGO <> 'ATENDENTE'

SELECT * 
FROM EMPREGADO
WHERE ( MONTH(DATANASCIMENTO)=12 )
AND CARGO <> 'ATENDENTE'