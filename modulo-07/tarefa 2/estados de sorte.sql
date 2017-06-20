create or replace package body pck_estadosDeSorte is

    /*
    function buscaEstado(pConcurso in integer) return varchar2 as
    v_estadoDeSorte varchar2(2);
    begin
        select c.Uf, sum(a.Valor)
        into v_estadoDeSorte
        from Cidade c
        inner join Aposta a on c.IDCIDADE = a.IDCIDADE
        where a.Idconcurso = 1824        
        group by c.Uf;
        
        having sum(a.Valor) = ( select max(sum(a.Valor))
                                from Cidade c
                                inner join Aposta a on c.IDCIDADE = a.IDCIDADE
                                where a.Idconcurso = 1824        
                                group by c.Uf
                                );
        return v_estadoDeSorte;
    end buscaEstado;*/

    procedure estadosDeSorte (pConcurso in integer) as
    
    cursor verificaEstados(pConcurso integer) is
        select c.Uf, sum(a.Valor) as Total, ap.Totalacertos
        from Cidade c
        inner join (select count(1) as Totalacertos, cid.uf as Uf
                    from Cidade cid
                    inner join Aposta ap on cid.Idcidade = ap.Idcidade
                    inner join Aposta_premiada app on app.Idaposta = ap.Idaposta
                    group by cid.uf)        
        ap on ap.Uf = c.Uf
        inner join Aposta a on c.Idcidade = a.Idcidade        
        where a.Idconcurso = pConcurso        
        group by c.Uf
        having sum(a.Valor) = ( select max(sum(a.Valor))
                                from Cidade c
                                inner join Aposta a on c.IDCIDADE = a.IDCIDADE
                                where a.Idconcurso = pConcurso        
                                group by c.Uf
                                );  
        
    begin
        PCK_MEGASENA.ATUALIZAACERTADORES(pConcurso);
        for e in verificaEstados(pConcurso) loop
            DBMS_OUTPUT.PUT_LINE('Estado: ' || e.Uf);
            DBMS_OUTPUT.PUT_LINE('Total arrecadado: ' || e.Total);
            DBMS_OUTPUT.PUT_LINE('Total acertos: ' || e.Totalacertos);
        end loop;
    end estadosDeSorte;

begin 
    null;
end pck_estadosDeSorte;





