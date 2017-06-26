CREATE TABLE CLIENTE (
              ID_CLIENTE INTEGER NOT NULL, 
              NM_CLIENTE VARCHAR2(60) NOT NULL, 
              CONSTRAINT CLIENTE_PK PRIMARY KEY (ID_CLIENTE)
);

create sequence sqcliente;


create or replace trigger TR_SQ_cliente 
    before insert on Cliente 
    for each row
    when (new.ID_CLIENTE is null)
Declare
    v_nome         varchar2(60);
Begin 
    Select     sqcliente.nextval
    into       :new.ID_CLIENTE
    from       Dual;    
End TR_SQ_cliente; 


insert into cliente (NM_CLIENTE) values ('Jomar');
commit;
