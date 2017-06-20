create or replace view vwFraudes (Idlogaposta) as
    select Idlogaposta
    from logaposta_operacao l
    inner join aposta a on l.Idaposta = a.Idaposta
    inner join Concurso c on c.Idconcurso = a.Idconcurso
    where l.Data_Operacao > c.Data_sorteio;

