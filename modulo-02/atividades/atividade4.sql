/*
Exercício 1: Datas
Liste todos os projetos que tiveram atrasos no início da obra, exibir também o
tempo previsto (em meses), e o tempo realizado (em meses) para a conclusão da obra.
*/

SELECT Identificador, Projeto, Data_Inicio_Prev, Data_Inicio_Real, Data_Fim_Prev , 
	DATEDIFF(mm, Data_Inicio_Prev, Data_Fim_Prev) AS Tempo_Previsto, Data_Fim_Real, 
	DATEDIFF(mm, Data_Inicio_Real, Data_Fim_Real) AS Tempo_Realizado
FROM Licitacao
WHERE Data_Inicio_Prev < Data_Inicio_Real

/*
Exercício 2: Ranking
Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado também o valor médio por profissional.
Por exemplo:
Empresa	Total Faturamento R$	Valor Médio por Profissional
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
Exercício 3: TOP Cidades
Liste as TOP 10 cidades com maior arrecação de impostos.
*/

SELECT TOP 10 
	Municipio,
	(CAST(SUM((Imposto_Estadual + Imposto_Federal + Imposto_Municipal)) AS NUMERIC(20,2))) AS Imposto_Arrecadado
FROM Licitacao
GROUP BY Municipio
ORDER BY Imposto_Arrecadado DESC

/*
Exercício 4: Finais de semana
Liste todos os projetos que tiveram a data de início (real) ocorrendo em finais de semana (sábado ou domingo).
*/

SELECT *
FROM Licitacao
WHERE DATEPART(dw,  Data_Inicio_Real) IN (1, 7)

/*
Exercício 5: Empresas com sorte
Liste todas as empresas que tiveram (ou terão) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/

SELECT Empresa_Licitante, (CAST(SUM(Valor_Realizado) AS NUMERIC(20,2))) AS Faturamento_Previsto, AVG(Faturamento_1Ano_Anterior) AS Faturamento_1Ano_Anterior
FROM Licitacao
GROUP BY Empresa_Licitante
HAVING SUM(Valor_Realizado) > SUM(Faturamento_1Ano_Anterior) * 0.5

/*
Exercício 6: Custo real
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
Exercício 7: Investigação
O projeto 17255 foi suspenso, o motivo foi o elevado custo para o orçamento anual do município.
 A partir de uma investigação mais detalhada foi visto que esse motivo não era a verdadeira razão. 
 Explique por que este motivo não é válido apresentando uma consulta com dados.
*/

O valor previsto é 11x menor do que o segundo melhor lance de outra empreiteira. Muito suspeito.