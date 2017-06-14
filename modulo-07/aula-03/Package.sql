create or replace package pck_cidades_repetidas as
  procedure mostrarRepetidos;
  procedure atribuirCidade;
end;

create or replace package body pck_cidades_repetidas as
  procedure mostrarRepetidos is
  begin
    declare
      cursor c_cidades is
           select Nome, UF, min(IDCIDADE) as ID_MINIMO
           from   Cidade
           group  by Nome, UF
           having count(1) >1;
      cursor c_clientes (pNome in varchar2,
                         pUF   in varchar2) is
         select cli.IDCliente,
                cli.Nome as Nome_Cliente,
                cid.Nome as Nome_Cidade,                
                cid.UF
         from   Cliente cli
          inner join Cidade cid on cid.IDCidade = cli.IDCidade
         where  cid.Nome = pNome
         and    cid.UF   = pUF;
    begin
      FOR c in c_cidades LOOP     
          dbms_output.put_line('Cidade: '|| c.Nome );
          FOR i in c_clientes (c.Nome, c.UF) LOOP
               dbms_output.put_line('Cliente: '|| i.Nome_Cliente );
               atribuirCidade(i.IDCliente, c.ID_MINIMO);
          END LOOP;
      END LOOP;
    end;
  end;
end;

create or replace package body pck_cidades_repetidas as
  procedure atribuirCidade (P_ID_CLIENTE NUMBER, PID_CIDADE NUMBER) is
    begin
      update CLIENTE set IDCIDADE = PID_CIDADE WHERE IDCLIENTE = P_ID_CLIENTE;
    end;
  end;
end;



 begin
  pck_cidades_repetidas.mostrarRepetidos;
end;

