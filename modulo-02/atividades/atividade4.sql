/*
Exerc�cio 1: Datas
Liste todos os projetos que tiveram atrasos no in�cio da obra, exibir tamb�m o
tempo previsto (em meses), e o tempo realizado (em meses) para a conclus�o da obra.
*/

SELECT Identificador, Projeto, Data_Inicio_Prev, Data_Inicio_Real, Data_Fim_Prev , 
	DATEDIFF(mm, Data_Inicio_Prev, Data_Fim_Prev) AS Tempo_Previsto, Data_Fim_Real, 
	DATEDIFF(mm, Data_Inicio_Real, Data_Fim_Real) AS Tempo_Realizado
FROM Licitacao
WHERE Data_Inicio_Prev < Data_Inicio_Real

/*
Exerc�cio 2: Ranking
Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado tamb�m o valor m�dio por profissional.
Por exemplo:
Empresa	Total Faturamento R$	Valor M�dio por Profissional
ABC Construcoes	11,976,510.00	48,426.81
*/

SELECT TOP 10 
	Empresa_Licitante, 
	(CAST(SUM(Valor_Realizado) AS NUMERIC(20,2))) AS Faturamento_Total, 
	(CAST(AVG(Valor_Realizado/Profissionais) AS NUMERIC(20,2))) AS Valor_Medio_Por_Profissional
FROM Licitacao
GROUP BY Empresa_Licitante
ORDER BY Faturamento_Total DESC

/*
Exerc�cio 3: TOP Cidades
Liste as TOP 10 cidades com maior arreca��o de impostos.
*/

SELECT TOP 10 
	Municipio,
	(CAST(SUM((Imposto_Estadual + Imposto_Federal + Imposto_Municipal)) AS NUMERIC(20,2))) AS Imposto_Arrecadado
FROM Licitacao
GROUP BY Municipio
ORDER BY Imposto_Arrecadado DESC

/*
Exerc�cio 4: Finais de semana
Liste todos os projetos que tiveram a data de in�cio (real) ocorrendo em finais de semana (s�bado ou domingo).
*/

SELECT *
FROM Licitacao
WHERE DATEPART(dw,  Data_Inicio_Real) IN (1, 7)

/*
Exerc�cio 5: Empresas com sorte
Liste todas as empresas que tiveram (ou ter�o) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/

SELECT Empresa_Licitante, (CAST(SUM(Valor_Realizado) AS NUMERIC(20,2))) AS Faturamento_Previsto, AVG(Faturamento_1Ano_Anterior) AS Faturamento_1Ano_Anterior
FROM Licitacao
GROUP BY Empresa_Licitante
HAVING SUM(Valor_Realizado) > SUM(Faturamento_1Ano_Anterior) * 0.5

/*
Exerc�cio 6: Custo real
Liste os projetos exibindo o custo real do projeto. 
Caso o projeto seja de esfera federal deve ser descontado o imposto federal, e assim respectivamente para as esferas estaduais e municipais.
*/

SELECT  Identificador, Projeto, Custo_Real_Projeto= 
	CASE Esfera
	WHEN 'Federal' THEN CAST(Valor_Realizado - Imposto_Federal AS NUMERIC(20,2))
	WHEN 'Estadual' THEN CAST(Valor_Realizado - Imposto_Estadual AS NUMERIC(20,2))
	WHEN 'Municipal' THEN CAST(Valor_Realizado - Imposto_Municipal AS NUMERIC(20,2))
	ELSE 'NADA'
	END, Esfera
	FROM Licitacao

/*
Exerc�cio 7: Investiga��o
O projeto 17255 foi suspenso, o motivo foi o elevado custo para o or�amento anual do munic�pio.
 A partir de uma investiga��o mais detalhada foi visto que esse motivo n�o era a verdadeira raz�o. 
 Explique por que este motivo n�o � v�lido apresentando uma consulta com dados.
*/

O valor previsto � 11x menor do que o segundo melhor lance de outra empreiteira. Muito suspeito.