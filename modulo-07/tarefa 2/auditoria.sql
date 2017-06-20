insert into Aposta (Idaposta, Idconcurso, Idcidade, Data_Hora, Quantidade_Numeros, Valor) 
  values (5000124, 1824, 171, sysdate, 6, 3.5); 
 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 14);  
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 15); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 23); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 54); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 27); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000124, 46); 
 
commit; 
rollback;


create or replace trigger TR_AUD1_NUMERO_APOSTA
    after insert or update or delete on NUMERO_APOSTA
    for each row
Declare
    v_Velho_IdNumero_Aposta         number(38,0);
    v_Novo_IdNumero_Aposta          number(38,0);
    v_Velho_Numero                  number(2,0);
    v_Novo_Numero                   number(2,0);
    v_Data_Operacao                 date;
    v_Usuario                       varchar2(30);
    v_Operacao                      char(1);
Begin
    if INSERTING then
        v_operacao := 'I';
        v_Velho_IdNumero_Aposta := null;
        v_Novo_IdNumero_Aposta := :new.IdNumero_Aposta;
        v_Velho_Numero := null;
        v_Novo_Numero := :new.Numero;        
   elsif UPDATING then
        v_operacao := 'U';  
        v_Velho_IdNumero_Aposta := :old.IdNumero_Aposta;
        v_Velho_Numero := :old.Numero;
        v_Novo_Numero := :new.Numero; 
   else
        v_operacao := 'D';
        v_Velho_IdNumero_Aposta := :old.IdNumero_Aposta;
        v_Velho_Numero := :old.Numero;
        v_Novo_Numero := null;
  end if; 
  Insert Into LogNumeroAposta_Operacao 
                    (
                    IdLogNumeroAposta,
                    Novo_IdNumero_Aposta,
                    Velho_Numero,
                    Novo_Numero,
                    Data_Operacao,
                    Usuario,
                    Operacao
                    )
              Values(
                    sqLogNumeroAposta_Operacao.nextval,
                    v_Novo_IdNumero_Aposta,
                    v_Velho_Numero,
                    v_Novo_Numero,
                    sysdate,
                    user,
                    v_Operacao
                    );            
End TR_AUD1_NUMERO_APOSTA;

create or replace trigger TR_AUD1_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  v_IdAposta                      integer;
  v_Velho_IdConcurso              integer;
  v_Novo_IdConcurso               integer;
  v_Velha_Data_hora               date;
  v_Nova_Data_Aposta              date;
  v_Velha_Quantidade_Numeros      number(2,0);
  v_Nova_Quantidade_Numeros       number(2,0);
  v_Velho_Valor                   number(9,2);
  v_Novo_Valor                    number(9,2);
  v_Velho_Bolao                   number(1,0);
  v_Novo_Bolao                    number(1,0);
  v_Data_Operacao                 date;
  v_Usuario                       varchar2(30);
  v_operacao                      char(1);
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IdAposta := :new.IdAposta;
     v_Velho_IdConcurso := null;
     v_Novo_IdConcurso := :new.IdConcurso;
     v_Velha_Data_hora := null;
     v_Nova_Data_Aposta := :new.Data_hora;
     v_Velha_Quantidade_Numeros := null;
     v_Nova_Quantidade_Numeros := :new.Quantidade_Numeros;
     v_Velho_Valor := null;
     v_Novo_Valor := :new.Valor;
     v_Velho_Bolao := null;
     v_Novo_Bolao := :new.Bolao;
  elsif UPDATING then
     v_operacao := 'U';     
     v_IdAposta := :new.IdAposta;
     v_Velho_IdConcurso := :old.IdConcurso;
     v_Novo_IdConcurso := :new.IdConcurso;
     v_Velha_Data_hora := :old.Data_hora;
     v_Nova_Data_Aposta := :new.Data_hora;
     v_Velha_Quantidade_Numeros := :old.Quantidade_Numeros;
     v_Nova_Quantidade_Numeros := :new.Quantidade_Numeros;
     v_Velho_Valor := :old.Valor;
     v_Novo_Valor := :new.Valor;
     v_Velho_Bolao := :old.Bolao;
     v_Novo_Bolao := :new.Bolao;
  else
     v_operacao := 'D';
     v_IdAposta := :old.IdAposta;
     v_Velho_IdConcurso := :old.IdConcurso;
     v_Novo_IdConcurso := null;
     v_Velha_Data_hora := :old.Data_hora;
     v_Nova_Data_Aposta := null;
     v_Velha_Quantidade_Numeros := :old.Quantidade_Numeros;
     v_Nova_Quantidade_Numeros := null;
     v_Velho_Valor := :old.Valor;
     v_Novo_Valor := null;
     v_Velho_Bolao := :old.Bolao;
     v_Novo_Bolao := null;
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
        values                    (sqLogAposta_Operacao.nextval, 
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

End TR_AUD1_APOSTA;