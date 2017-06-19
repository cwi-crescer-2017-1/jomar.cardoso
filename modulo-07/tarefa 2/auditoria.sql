insert into Aposta (Idaposta, Idconcurso, Idcidade, Data_Hora, Quantidade_Numeros, Valor) 
  values (5000125, 1824, 171, sysdate, 6, 3.5); 
 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 14);  
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 15); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 23); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 54); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 27); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000125, 46); 
 
commit; 
rollback;


/*
Exercício 1: Auditoria Loteria
Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. 
A auditoria deve monitorar tanto as apostas quanto os números de cada aposta.
*/


/*DROP TABLE  LogAposta_Operacao;*/

Create table LogAposta_Operacao (
  IdLogAposta                   integer not null,
  IdAposta                      integer not null,
  Velho_IdConcurso              integer not null,
  Novo_IdConcurso               integer,
  Velha_Data_hora               date,  
  Nova_Data_Aposta              date,
  Velha_Quantidade_Numeros      number(2,0),
  Nova_Quantidade_Numeros       number(2,0),
  Velho_Valor                   number(9,2),
  Novo_Valor                    number(9,2),
  Velho_Bolao                   number(1,0),
  Novo_Bolao                    number(1,0),
  Data_Operacao                 date default sysdate,
  Usuario                       varchar2(30) not null,
  Operacao                      char(1) not null,
    constraint LogAposta_Operacao 
       primary key (IdLogAposta)
);

Create sequence sqLogAposta_Operacao;

/*drop sequence sqLogAposta_Operacao;*/



create or replace
trigger TR_AUD1_APOSTA
    after insert or update or delete on APOSTA
Declare
  v_operacao char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
  elsif UPDATING then
     v_operacao := 'U';       
  else
     v_operacao := 'D';
  end if;
  Insert into LogAposta_Operacao (IdLogAposta, 
                                  IdAposta, 
                                  Velho_IdConcurso, 
                                  Novo_IdConcurso,
                                  Velha_Data_hora,
                                  Nova_Data_Aposta,
                                  Velha_Quantidade_Numeros,
                                  Nova_Quantidade_Numeros,
                                  Velho_Valor,
                                  Novo_Valor,
                                  Velho_Bolao,
                                  Novo_Bolao,
                                  Data_Operacao,
                                  Usuario,
                                  Operacao)
        values                    (sqlogcliente_operacao.nextval, 
                                  v_IdAposta,
                                  v_Velho_IdConcurso,
                                  v_Novo_IdConcurso,
                                  v_Velha_Data_hora,
                                  v_Nova_Data_Aposta,
                                  v_Velha_Quantidade_Numeros,
                                  v_Nova_Quantidade_Numeros,
                                  v_Velho_Valor,
                                  v_Novo_Valor,
                                  v_Velho_Bolao,
                                  v_Novo_Bolao,
                                  sysdate,
                                  user,
                                  v_operacao);

End TR_AUD1_CLIENTE;

SELECT * FROM LogAposta_Operacao;

rollback;